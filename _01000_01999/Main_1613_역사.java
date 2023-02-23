package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 37,232kb
// 504ms

public class Main_1613_역사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static final int INF = 9999999;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] aM = new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			aM[a - 1][b - 1] = -1;
			aM[b - 1][a - 1] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (aM[i][j] == 0 && i != j)
					aM[i][j] = INF;
			}
		}

		// floyd-warshall

		for (int c = 0; c < n; c++) {
			for (int a = 0; a < n; a++) {
				if (c == a)
					continue;
				for (int b = 0; b < n; b++) {
					if (a == b || b == c)
						continue;
					if (aM[a][c] + aM[c][b] == 2)
						aM[a][b] = 1;
					else if (aM[a][c] + aM[c][b] == -2)
						aM[a][b] = -1;
				}
			}
		}

		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			int res = aM[a - 1][b - 1] == INF ? 0 : aM[a - 1][b - 1];
			sb.append(res).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}