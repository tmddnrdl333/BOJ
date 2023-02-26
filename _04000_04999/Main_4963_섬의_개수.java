package ps.BOJ._04000_04999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 13,736kb
// 125ms

public class Main_4963_섬의_개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int h, w;
	static int[][] map;
	static int cnt;

	static int[] dr = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			cnt = 0;
			if (w == 0 || h == 0)
				break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 0)
						continue;
					else
						BFS(i, j);
				}
			}

			sb.append(cnt).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void BFS(int i, int j) {
		map[i][j] = 0;
		cnt++;
		Queue<Integer> q = new LinkedList<>();
		int idx = i * w + j;
		q.add(idx);

		while (!q.isEmpty()) {
			int cidx = q.poll();
			int cr = cidx / w, cc = cidx % w;
			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d], nc = cc + dc[d];
				if (nr == -1 || nc == -1 || nr == h || nc == w)
					continue;
				if (map[nr][nc] == 0)
					continue;
				map[nr][nc] = 0;
				q.add(nr * w + nc);
			}
		}
	}
}