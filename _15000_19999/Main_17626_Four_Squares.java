package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12,408kb
// 112ms

public class Main_17626_Four_Squares {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int l = (int) Math.sqrt(N);
		int[] squares = new int[l + 1];
		for (int i = 1; i <= l; i++)
			squares[i] = i * i;
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 4);
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			int j = 1;
			for (; j <= l && i - squares[j] >= 0; j++) {
				int tmp = dp[i - squares[j]] + 1;
				dp[i] = tmp < dp[i] ? tmp : dp[i];
			}
		}

		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
	}
}