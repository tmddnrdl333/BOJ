package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 13,644kb
// 112ms

public class Main_9205_맥주_마시면서_걸어가기 {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n;
	static int hx, hy;
	static Point[] pts;
	static boolean[] my;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (; t != 0; t--) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());

			//
			pts = new Point[n + 1];
			my = new boolean[n + 1];
			for (int i = 0; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int curX = Integer.parseInt(st.nextToken());
				int curY = Integer.parseInt(st.nextToken());
				pts[i] = new Point(curX, curY);
				if (Math.abs(hx - curX) + Math.abs(hy - curY) <= 1000) {
					my[i] = true;
				}
			}
			boolean update = true;
			while (update) {
				update = false;
				for (int i = 0; i < n + 1; i++) {
					if (!my[i]) {
						// my 편입 가능한지 확인하고 편입시켜줌
						// update=true해줌
						for (int j = 0; j < n + 1; j++)
							if (my[j])
								if (Math.abs(pts[i].x - pts[j].x) + Math.abs(pts[i].y - pts[j].y) <= 1000) {
									my[i] = true;
									update = true;
								}
					}
				}
			}
			if (my[n])
				sb.append("happy\n");
			else
				sb.append("sad\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}