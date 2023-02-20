package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 11,744kb
// 80ms

public class Main_13460_구슬_탈출_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static char[][] map;
	static int Ridx, Bidx;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 }; // 상 좌 하 우

	static int res = -1;
	static Set<Integer> set = new HashSet<>(); // BFS 방문체크용 : 두 공의 위치 조합을 한 숫자로 나타낸 값

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				char tempc = temp[j];
				if (tempc == 'R') {
					Ridx = i * M + j;
					map[i][j] = '.';
				} else if (tempc == 'B') {
					Bidx = i * M + j;
					map[i][j] = '.';
				} else
					map[i][j] = tempc;
			}
		}

		BFS();

		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();

	}

	public static void BFS() {
		int time = 0;
		Queue<Integer> q = new LinkedList<>();
		int init = Ridx + Bidx * 100;
		q.add(init);
		set.add(init);
		w: while (!q.isEmpty()) { // while
			time++;
			int qsize = q.size();
			for (; qsize != 0; qsize--) { // 1회
				int cur = q.poll();
				int ridx = cur % 100, bidx = cur / 100;
				for (int d = 0; d < 4; d++) { // 4방
					int moved = move(ridx, bidx, d);
					if (moved < 0) {
						if (moved == -1) {
							res = time;
							break w;
						} else
							continue;
					}
					if (!set.contains(moved)) {
						q.add(moved);
						set.add(moved);
					}
				} // 4방
			} // 1회
			if (time == 10) {
				res = -1;
				break;
			}
		} // while

	}

	public static int move(int ridx, int bidx, int d) {
		// idx를 (r,c)로
		int rr = ridx / M, rc = ridx % M;
		int br = bidx / M, bc = bidx % M;

		boolean collide = false; // 마주치면 true

		// 빨간공 먼저, 벽or홀 에 도착할 때까지 이동
		while (true) {
			rr += dr[d];
			rc += dc[d];
			if (rr == br && rc == bc) // 파란공을 만났다면 기록(함께 처리할 수 있음)
				collide = true;
			else if (map[rr][rc] == '#') // 벽 도착
				break;
			else if (map[rr][rc] == 'O') { // 홀 도착
				ridx = 100; // 100은 홀인
				break;
			}
		}

		if (ridx == 100 && collide)
			return -3; // 함께 홀인

		if (collide) { // 중간에 파란공을 만났고, 같이 벽에 부딛힘. return
			br = rr - dr[d];
			bc = rc - dc[d];
			rr = br - dr[d];
			rc = bc - dc[d];
			ridx = rr * M + rc;
			bidx = br * M + bc;
			int ret = ridx + bidx * 100;
			return ret;
		} else { // 만나지 못했다면... 파란공은 아래에서 따로 처리
			if (ridx != 100) {
				rr -= dr[d];
				rc -= dc[d];
				ridx = rr * M + rc;
			} else {
				rr = -1; // 아래에서 파란공이 빨간 공을 만난다는 판정이 일어나지 않게
			}
		}

		// 파란 공 차례, 벽or홀or이동한 빨간 공 만날 때까지 이동
		while (true) {
			br += dr[d];
			bc += dc[d];
			if (map[br][bc] == '#' || rr == br && rc == bc)
				break;
			else if (map[br][bc] == 'O') {
				bidx = 100;
				break;
			}
		}
		if (ridx == 100 && bidx == 100) {
			return -3;
		} else if (bidx == 100 && ridx != 100) {
			return -2;
		} else if (ridx == 100 && bidx != 100) {
			return -1;
		}
		br -= dr[d];
		bc -= dc[d];
		bidx = br * M + bc;
		return ridx + bidx * 100;
	}
}
