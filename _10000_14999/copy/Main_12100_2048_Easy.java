package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 18340kb
// 128ms

public class Main_12100_2048_Easy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[][][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 }; // 상 좌 하 우

	static int max = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[6][N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[0][i][j] = Integer.parseInt(st.nextToken());
		}

		execute(0);

		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
	}

	public static void execute(int cnt) {

		if (cnt == 5) {
			int cur = largest();
			max = cur > max ? cur : max;
			return;
		}

		for (int d = 0; d < 4; d++) {
			// map[cnt]의 정보로 map[cnt+1]를 덮어씀
			merge(cnt, d);

			execute(cnt + 1);
		}

	}

	public static void merge(int cnt, int d) {
		int[][] before = new int[N][N];
		int[][] after = new int[N][N];
		before = map[cnt];
		int is = 0, ie = N;
		int js = 0, je = N;
		int ia = 1, ja = 1;
		if (d == 2) { // 하
			is = N - 1;
			ie = -1;
			ia = -1;
		} else if (d == 3) { // 우
			js = N - 1;
			je = -1;
			ja = -1;
		}

		if (d % 2 == 0) {
			for (int j = 0; j < N; j++) {
				int ic = is; // after에 쌓인 놈 인덱스 (시작시 예외)
				int i = is; // before에서 검사할 놈 인덱스
				while (i != ie) {
					if (after[ic][j] == 0) {
						if (before[i][j] != 0)
							after[ic][j] = before[i][j];
					} else if (after[ic][j] != 0) {
						if (before[i][j] == after[ic][j]) {
							after[ic][j] *= 2;
							ic += ia;
						} else if (before[i][j] == 0) {
						} else {
							ic += ia;
							after[ic][j] = before[i][j];
						}
					}
					i += ia;
				}
			}
		} else
			for (int i = 0; i < N; i++) {
				int jc = js;
				int j = js;
				while (j != je) {
					if (after[i][jc] == 0) {
						if (before[i][j] != 0)
							after[i][jc] = before[i][j];
					} else if (after[i][jc] != 0) {
						if (before[i][j] == after[i][jc]) {
							after[i][jc] *= 2;
							jc += ja;
						} else if (before[i][j] == 0) {
						} else {
							jc += ja;
							after[i][jc] = before[i][j];
						}
					}
					j += ja;
				}
			}
		map[cnt + 1] = after;
	}

	public static int largest() {
		int ret = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int cur = map[5][i][j];
				ret = cur > ret ? cur : ret;
			}
		return ret;
	}

}