package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,580kb
// 80ms

public class Main_1331_나이트_투어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		boolean[][] map = new boolean[6][6];

		String init = br.readLine();
		int r = init.charAt(0) - 'A', c = init.charAt(1) - '1';
		map[r][c] = true;

		int cr = r, cc = c;

		boolean oflag = true;
		boolean iflag = false;

		for (int i = 1; i < 36; i++) {
			String inp = br.readLine();
			int nr = inp.charAt(0) - 'A', nc = inp.charAt(1) - '1';

			iflag = false;
			for (int d = 0; d < 8; d++) {
				if (cr + dr[d] == nr && cc + dc[d] == nc) {
					iflag = true;
					break;
				}
			}
			if (!iflag) {
				oflag = false;
			} else {
				cr = nr;
				cc = nc;
				if (map[cr][cc])
					oflag = false;
				map[cr][cc] = true;
			}

		}

		iflag = false;
		for (int d = 0; d < 8; d++)
			if (cr + dr[d] == r && cc + dc[d] == c)
				iflag = true;

		if (oflag && iflag)
			bw.write("Valid");
		else
			bw.write("Invalid");
		bw.flush();
		bw.close();
	}
}