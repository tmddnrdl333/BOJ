package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 28,616kb
// 320ms

public class Main_8911_거북이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	// L:+1, R:-1
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (; T > 0; T--) {
			char[] arr = br.readLine().toCharArray();

			int r = 0, c = 0, dir = 0;
			int rmax = 0, rmin = 0, cmax = 0, cmin = 0;

			for (char com : arr) {
				switch (com) {
				case 'F':
					r += dr[dir];
					c += dc[dir];
					break;
				case 'B':
					r -= dr[dir];
					c -= dc[dir];
					break;
				case 'L':
					dir = (dir + 3) % 4;
					break;
				case 'R':
					dir = (dir + 1) % 4;
					break;
				default:
					break;
				}
				rmax = r > rmax ? r : rmax;
				rmin = r < rmin ? r : rmin;
				cmax = c > cmax ? c : cmax;
				cmin = c < cmin ? c : cmin;
			}

			sb.append((rmax - rmin) * (cmax - cmin)).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}