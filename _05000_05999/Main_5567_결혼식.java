package ps.BOJ._05000_05999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 16,160kb
// 124ms

public class Main_5567_결혼식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[][] aM = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			aM[a][b] = true;
			aM[b][a] = true;
		}
		boolean[] res = new boolean[n + 1];
		res[1] = true;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (aM[1][i]) {
				if (i != 1 && !res[i]) {
					res[i] = true;
					cnt++;
				}
				for (int j = 1; j <= n; j++) {
					if (aM[i][j] && !res[j]) {
						cnt++;
						res[j] = true;
					}
				}
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}