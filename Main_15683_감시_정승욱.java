package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 25,784kb
// 224ms

public class Main_15683_감시_정승욱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static int[][] map;
	static List<int[]> cctv = new ArrayList<>(); // i,j에 X번 cctv가 있다.
	static int min = Integer.MAX_VALUE;

	static int[][] d = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상 좌 하 우 (반시계)

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 5)
					cctv.add(new int[] { i, j, map[i][j] }); // i,j에 X번 cctv가 있다.
			}
		}
		// 입력 끝

		// 5 먼저 때운다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				if (map[i][j] == 5)
					cctv5(i, j);
		}

		func(0);

		// 결과 출력
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}

	public static int checkResult() {
		int cnt0 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt0++;
			}
		}
		return cnt0;
	}

	public static void cctv5(int r, int c) {
		int or = r;
		int oc = c;
		for (int dir = 0; dir < 4; dir++) {
			r = or;
			c = oc;
			while (r >= 0 && c >= 0 && r < N && c < M) {
				if (map[r][c] == 0) { // 0일 경우에만 채워주고, 1~5면 건너뛰고
					map[r][c] = 8;
				} else if (map[r][c] == 6) // 6일 경우에는 멈춰준다
					break;
				r += d[dir][0]; // 다음 위치도 가능할까?
				c += d[dir][1];
			}
		}
	}

	//
	public static void func(int cnt) {
		if (cnt == cctv.size()) {
			int temp = checkResult();
			min = temp < min ? temp : min;
			return;
		}
		// cnt번째 cctv가 볼 수 있는 방향의 수
		int dir = 0;
		int type = cctv.get(cnt)[2];
		if (type == 1 || type == 3 || type == 4)
			dir = 4;
		else if (type == 2)
			dir = 2;

		for (int i = 0; i < dir; i++) {
			int cr = cctv.get(cnt)[0];
			int cc = cctv.get(cnt)[1];
			watch(cr, cc, i);
			if (type == 2)
				watch(cr, cc, (i + 2) % 4);
			else if (type == 3)
				watch(cr, cc, (i + 3) % 4);
			else if (type != 1) {
				watch(cr, cc, (i + 3) % 4);
				watch(cr, cc, (i + 1) % 4);
			}
			// i번째 방향으로 먹은 칸들을 칠해준 후

			// func에 cnt+1을 담아 재귀호출
			func(cnt + 1);

			//
			// 내가 먹었던 칸들을 다시 0으로 만들어줌
			unwatch(cr, cc, i);
			if (type == 2)
				unwatch(cr, cc, (i + 2) % 4);
			else if (type == 3)
				unwatch(cr, cc, (i + 3) % 4);
			else if (type != 1) {
				unwatch(cr, cc, (i + 3) % 4);
				unwatch(cr, cc, (i + 1) % 4);
			}
		}
	}

	public static void watch(int r, int c, int dir) {
		// 입력된 방향으로 한 칸 이동한다면?
		int nr = r + d[dir][0];
		int nc = c + d[dir][1];
		// 맵을 벗어났다면 리턴
		if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
			return;
		}
		// 가능하니 대입
		r = nr;
		c = nc;
		// 벽을 만났다면 리턴
		if (map[r][c] == 6) {
			return;
		} else if (map[r][c] < 1) {
			map[r][c] -= 1;
		}
		watch(r, c, dir);
	}

	public static void unwatch(int r, int c, int dir) {
		// 입력된 방향으로 한 칸 이동한다면?
		int nr = r + d[dir][0];
		int nc = c + d[dir][1];
		// 맵을 벗어났다면 리턴
		if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
			return;
		}
		// 가능하니 대입
		r = nr;
		c = nc;
		// 벽을 만났다면 리턴
		if (map[r][c] == 6) {
			return;
		} else if (map[r][c] < 0) {
			map[r][c] += 1;
		}
		unwatch(r, c, dir);
	}

}
