package algorithm_hw.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// 12,884kb
// 108ms

public class Main_10026_적록색약_정승욱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 }; // 상 하 좌 우

	static int cnt1 = 0;
	static int cnt2 = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - 66; // R 16 G 5 B 0
			}
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (map[i][j] >= 0)
					bfs1(i, j);
		reMap();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (map[i][j] >= 0)
					bfs2(i, j);

		bw.write(cnt1 + " " + cnt2);
		bw.flush();
		bw.close();
	}

	public static void bfs1(int r, int c) {
		if (map[r][c] < 0) // 이미 방문한 곳이라면 리턴
			return;
		cnt1++; // 하나의 무리 끝까지 만들기, bfs로
		int color = map[r][c];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		map[r][c] -= 20;
		while (!q.isEmpty()) {
			int[] co = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = co[0] + dr[dir];
				int nc = co[1] + dc[dir];
				// 갈 수 없는 곳은 볼 필요 없다.
				if (nr == -1 || nr == N || nc == -1 || nc == N)
					continue;
				// 방문하지 않았고, 같은 색이라면 방문체크하고 큐에 넣어준다
				else if (map[nr][nc] == color) {
					q.add(new int[] { nr, nc });
					map[nr][nc] -= 20;
				}
			}
		} // while
	}

	public static void reMap() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] += 20;
	}

	public static void bfs2(int r, int c) {
		if (map[r][c] < 0) // 이미 방문한 곳이라면 리턴
			return;
		cnt2++; // 하나의 무리 끝까지 만들기, bfs로
		boolean color = map[r][c] > 0 ? true : false;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		map[r][c] -= 20;
		while (!q.isEmpty()) {
			int[] co = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = co[0] + dr[dir];
				int nc = co[1] + dc[dir];
				// 갈 수 없는 곳은 볼 필요 없다.
				if (nr == -1 || nr == N || nc == -1 || nc == N)
					continue;
				// 방문하지 않았고, 같은 색이라면 방문체크하고 큐에 넣어준다
				else if ((color && map[nr][nc] > 0) || (!color && map[nr][nc] == 0)) {
					q.add(new int[] { nr, nc });
					map[nr][nc] -= 20;
				}
			}
		} // while
	}
}
