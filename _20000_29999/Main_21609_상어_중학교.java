package ps.BOJ._20000_29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 15,676kb
// 124ms

public class Main_21609_상어_중학교 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static int[][] map;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	static int score = 0;

	static int selectedZeroCnt = 0;
	static int selectedBlockCnt = 0;
	static List<Integer> selectedList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		while (true) {
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
			selectedZeroCnt = 0;
			selectedBlockCnt = 0;

			// 블록 선택하기
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (map[i][j] > 0 && map[i][j] < 6)
						BFS(i, j);
			recover();

//			TEST();

			// 탈출조건
			if (selectedBlockCnt < 2) {
				break;
			}

			// 블록 지우기
			for (int idx : selectedList)
				map[idx / N][idx % N] = -5;
			score += selectedBlockCnt * selectedBlockCnt;

//			System.out.println("블록을 지웠음");
//			TEST();

			// 중력 작용
			gravity();

//			System.out.println("중력을 작용함");
//			TEST();

			rotate();

//			System.out.println("회전함");
//			TEST();

			gravity();

//			System.out.println("중력을 작용함");
//			TEST();
//			System.out.println("## score : " + score);
		}

		bw.write(Integer.toString(score));
		bw.flush();
		bw.close();
	}

	public static void TEST() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -5)
					System.out.printf("   ");
				else if (map[i][j] == -1)
					System.out.print("  X");
				else
					System.out.printf("%3d", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void BFS(int r, int c) {
		int zeroCnt = 0; // 무지개 개수
		int blockCnt = 1; // 블록 개수
		Queue<Integer> q = new LinkedList<>(); // BFS를 위한 Queue
		List<Integer> pts = new ArrayList<>(); // 이번 BFS에서 탐색한 점들

		int sIdx = r * N + c; // 출발점
		int color = map[r][c]; // 그 색
		map[r][c] += 10; // 방문체크
		q.add(sIdx);
		pts.add(sIdx);

		while (!q.isEmpty()) {
			int cIdx = q.poll();
			int cr = cIdx / N, cc = cIdx % N;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d], nc = cc + dc[d];
				if (nr == -1 || nc == -1 || nr == N || nc == N)
					continue;
				if (map[nr][nc] == color || map[nr][nc] == 0) {
					if (map[nr][nc] == 0)
						zeroCnt++;
					map[nr][nc] += 10;
					int nIdx = nr * N + nc;
					q.add(nIdx);
					pts.add(nIdx);
					blockCnt++;
				}
			}
		}

		for (int tIdx : pts) {
			int tr = tIdx / N, tc = tIdx % N;
			if (map[tr][tc] == 10)
				map[tr][tc] -= 10;
		}

		// 무지개 블록이 많거나 같다면 갈아끼우기
		if (blockCnt > selectedBlockCnt || (blockCnt == selectedBlockCnt && zeroCnt >= selectedZeroCnt)) {
			selectedBlockCnt = blockCnt;
			selectedZeroCnt = zeroCnt;
			selectedList = pts;
		}
	}

	public static void recover() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (map[i][j] > 10)
					map[i][j] -= 10;
	}

	public static void gravity() {
		for (int j = 0; j < N; j++) {
			int i = N - 1, floor = N - 1;
			while (i != -1) {
				if (map[i][j] == -5) {
					i--;
				} else if (map[i][j] == -1) {
					floor = --i;
				} else {
					if (floor != i) {
						map[floor][j] = map[i][j];
						map[i][j] = -5;
					}
					floor--;
					--i;
				}
			}
		}
	}

	public static void rotate() {
		int[][] tempMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tempMap[i][j] = map[j][N - 1 - i];
			}
		}
		map = tempMap;
	}
}