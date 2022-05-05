package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 39,352kb
// 148ms

public class Main_12852_1로_만들기_2_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][2];
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 0;
		for (int i = 2; i <= n; i++) {
			int a = i % 3 == 0 ? dp[i / 3][0] + 1 : Integer.MAX_VALUE;
			int b = i % 2 == 0 ? dp[i / 2][0] + 1 : Integer.MAX_VALUE;
			int c = dp[i - 1][0] + 1;
			int min = Math.min(a, Math.min(b, c));
			dp[i][0] = min;
			if (min == a)
				dp[i][1] = i / 3;
			else if (min == b)
				dp[i][1] = i / 2;
			else
				dp[i][1] = i - 1;
		}
		int i = n;
		sb.append(dp[n][0] + "\n" + n + " ");
		while (dp[i][1] != 0) {
			sb.append(dp[i][1] + " ");
			i = dp[i][1];
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}