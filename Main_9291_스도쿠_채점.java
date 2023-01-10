package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,516kb
// 100ms

public class Main_9291_스도쿠_채점 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("Case ").append(t).append(": ");

			boolean flag = true;

			boolean[][] row = new boolean[9][9];
			boolean[][] col = new boolean[9][9];
			boolean[][][] cell = new boolean[3][3][9];

			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					int tmp = Integer.parseInt(st.nextToken()) - 1;

					if (!row[i][tmp])
						row[i][tmp] = true;
					else {
						flag = false;
						break;
					}

					if (!col[j][tmp])
						col[j][tmp] = true;
					else {
						flag = false;
						break;
					}

					if (!cell[i / 3][j / 3][tmp])
						cell[i / 3][j / 3][tmp] = true;
					else {
						flag = false;
						break;
					}

				}
			}

			if (flag)
				sb.append("CORRECT\n");
			else
				sb.append("INCORRECT\n");

			if (t != T)
				br.readLine();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}