package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 34,844kb
// 304ms

public class Main_21610_마법사_상어와_비바라기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static int[][] map;

	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static Set<Integer> cloud = new HashSet<>();

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

		// 좌하단 구름 4칸 생성
		cloud.add(N * N - N);
		cloud.add(N * N - N + 1);
		cloud.add(N * N - 2 * N);
		cloud.add(N * N - 2 * N + 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			rain(d, s);
		}

		bw.write(Integer.toString(count()));
		bw.flush();
		bw.close();

	}

	public static void rain(int d, int s) {
		// 모든 구름있는 지역 물+1, 이동한 구름 nCloud에 저장
		Set<Integer> nCloud = new HashSet<>();
		for (int idx : cloud) {
			int r = (idx / N + dr[d] * s) % N;
			r = r < 0 ? r + N : r;
			int c = (idx % N + dc[d] * s) % N;
			c = c < 0 ? c + N : c;
			map[r][c]++;
			nCloud.add(r * N + c);
		}
		cloud.clear();
		// 물복사버그 마법 : 대각선에 물이 있는 바구니만큼 물 증가
		for (int idx : nCloud) {
			int r = idx / N, c = idx % N;
			for (int di = 1; di < 9; di += 2) {
				int nr = r + dr[di], nc = c + dc[di];
				if (nr == -1 || nc == -1 || nr == N || nc == N)
					continue;
				if (map[nr][nc] != 0)
					map[r][c]++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int idx = i * N + j;
				if (map[i][j] > 1 && !nCloud.contains(idx)) {
					map[i][j] -= 2;
					cloud.add(idx);
				}
			}
		}
	}

	public static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				cnt += map[i][j];
		return cnt;
	}
}