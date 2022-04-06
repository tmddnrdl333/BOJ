package ps_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 121,876kb
// 616ms

public class Main_9465_스티커 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n + 1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[2][n + 1];

			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for (int i = 2; i <= n; i++) {
				dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
				dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
			}

			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}