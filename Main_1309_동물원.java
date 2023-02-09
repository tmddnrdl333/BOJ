package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 14,368kb
// 92ms

public class Main_1309_동물원 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][2];
		dp[1][0] = 1;
		dp[1][1] = 2;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
			dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1]) % 9901;
		}

		bw.write((dp[N][0] + dp[N][1]) % 9901 + "");
		bw.flush();
		bw.close();
	}
}