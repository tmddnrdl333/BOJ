package study.day0221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 144,524kb
// 596ms

public class study_boj_7576_토마토 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static int[][] map;

	static boolean flag = true;
	static int day = -1;
	static Queue<int[]> q;
	static Queue<int[]> inQ;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		if (isEnd())
			bw.write(Integer.toString(day));
		else
			bw.write("-1");
		bw.flush();
		bw.close();

	}

	// 다 익었는지?
	public static boolean isEnd() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) // 0 안 익은 토마토 하나라도 있다면 아직이다.
					return false;
			}
		}
		return true;
	}

	public static void bfs() {

		// 1. 익은 토마토(1)를 다 q에 넣어줌
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					q.add(new int[] { i, j });
			}
		}

		// 2. 주변 토마토 익히기
		// - 현재 q에 있는 애들은 다 뽑아서 inQ로 넣어주고,
		// - inQ에 있는 애들을 하나씩 뽑으면서 익힘 + 다음에 주변을 익힐 애들 q로 넣어줌
		while (!q.isEmpty()) {
			inQ = new LinkedList<>();
			while (!q.isEmpty()) { // q 애들 다 뽑아서 inQ에 넣기
				inQ.add(q.poll());
			}
			while (!inQ.isEmpty()) { // inQ 애들 다 뽑으면서 익히고 q에 넣기
				int[] temp = inQ.poll();
				affect(temp);
			}
			day++;
		}

	}

	public static void affect(int[] temp) {
		int r = temp[0], c = temp[1];
		map[r][c] = 2; // 이미 주변을 다 익힌 토마토이다.
		if (r != 0 && map[r - 1][c] == 0) {
			map[r - 1][c] = 1; // 주변을 익혀야 하는 토마토이다.
			q.add(new int[] { r - 1, c });
		}
		if (c != 0 && map[r][c - 1] == 0) {
			map[r][c - 1] = 1;
			q.add(new int[] { r, c - 1 });
		}
		if (r != N - 1 && map[r + 1][c] == 0) {
			map[r + 1][c] = 1;
			q.add(new int[] { r + 1, c });
		}
		if (c != M - 1 && map[r][c + 1] == 0) {
			map[r][c + 1] = 1;
			q.add(new int[] { r, c + 1 });
		}
	}
}
