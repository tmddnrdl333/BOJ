package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 17,144kb
// 148ms

public class Main_17837_새로운_게임_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Piece {
		int r, c, d;

		Piece(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		void changePosition(int r, int c) {
			this.r = r;
			this.c = c;
		}

		void changeDirection() {
			if (this.d <= 2)
				this.d = 3 - this.d;
			else
				this.d = 7 - this.d;
		}
	}

	// N : 체스판 크기
	// K : 말 개수
	static int N, K;
	// map : 체스판 색 정보 (0-흰, 1-빨강, 2-파랑)
	static int[][] map;
	// pieces : 체스 말 정보
	static Piece[] pieces;
	// height : 체스 말 쌓은 정보
	static Map<Integer, Stack<Integer>> height = new HashMap<>();

	// 1: →, 2: ←, 3: ↑, 4: ↓
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		pieces = new Piece[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pieces[i] = new Piece(r, c, d);
			Stack<Integer> stack = new Stack<>();
			stack.add(i);
			height.put(r * (N + 1) + c, stack);
		}

		int cnt = 1;
		for (; cnt <= 1000; cnt++) {
			if (exec())
				continue;
			else
				break;
		}
		if (cnt == 1001)
			bw.write("-1");
		else
			bw.write(cnt + "");
		bw.flush();
		bw.close();

	}

	// 한 턴
	static boolean exec() {
		for (int i = 0; i < K; i++) {
			if (movePiece(i))
				continue;
			else
				return false;
		}
		return true;
	}

	// true: 성공, 다음 말
	// false: 게임 종료!
	static boolean movePiece(int i) {
		Piece piece = pieces[i];
		int r = piece.r, c = piece.c;
		int d = piece.d;

		// 다음 칸 (장외 혹은 파랑시 변경)
		int nr = piece.r + dr[d];
		int nc = piece.c + dc[d];

		// 01. 장외 or 파랑 : 방향 바꿔서 한 칸 가보기
		if (nr == N + 1 || nr == 0 || nc == N + 1 || nc == 0 || map[nr][nc] == 2) {

			// 방향 전환
			piece.changeDirection();
			d = piece.d;

			// 다음 칸 재설정
			nr = r + dr[d];
			nc = c + dc[d];

			// 01-1. 방향 바꾼 다음 칸도 장외 or 파랑 -> 다음 말
			if (nr == N + 1 || nr == 0 || nc == N + 1 || nc == 0 || map[nr][nc] == 2) {
				return true;
			}
		}
		// (01를 거쳤든 안거쳤든 nr과 nc는 다음 칸으로 확정됨)

		// 02. 다음 칸이 흰색
		if (map[nr][nc] == 0) {

			// 02-0. 이번에 쌓을 것들
			Stack<Integer> myStack = new Stack<>();
			while (!height.get(r * (N + 1) + c).isEmpty()) {
				int pop = height.get(r * (N + 1) + c).pop();
				myStack.add(pop);
				if (pop == i)
					break;
			}

			// 02-1. 지금과 다음의 합이 4개 이상 -> 게임 종료
			if (myStack.size() + height.getOrDefault(nr * (N + 1) + nc, new Stack<>()).size() >= 4) {
				return false;
			}
			// 02-2. 쌓을 수 있다면 쌓고 -> 다음 말
			else {
				Stack<Integer> newStack = height.getOrDefault(nr * (N + 1) + nc, new Stack<>());
				while (!myStack.isEmpty()) {
					int pop = myStack.pop();
					pieces[pop].changePosition(nr, nc);
					newStack.add(pop);
				}
				height.put(nr * (N + 1) + nc, newStack);
			}
		}

		// 03. 다음 칸이 빨간색 (map = 1)
		else {

			// 03-0. 이번에 쌓을 것들
			Queue<Integer> myQueue = new LinkedList<>();
			while (!height.get(r * (N + 1) + c).isEmpty()) {
				int pop = height.get(r * (N + 1) + c).pop();
				myQueue.add(pop);
				if (pop == i)
					break;
			}

			// 03-1. 지금과 다음의 합이 4개 이상 -> 게임 종료
			if (myQueue.size() + height.getOrDefault(nr * (N + 1) + nc, new Stack<>()).size() >= 4) {
				return false;
			}
			// 03-2. 쌓을 수 있다면 거꾸로 쌓고 -> 다음 말
			else {
				Stack<Integer> newStack = height.getOrDefault(nr * (N + 1) + nc, new Stack<>());
				while (!myQueue.isEmpty()) {
					int poll = myQueue.poll();
					pieces[poll].changePosition(nr, nc);
					newStack.add(poll);
				}
				height.put(nr * (N + 1) + nc, newStack);
			}
		}

		return true;

	}
}