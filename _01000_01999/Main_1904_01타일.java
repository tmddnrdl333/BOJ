package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 15,532kb
// 96ms

public class Main_1904_01타일 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static final int MOD = 15746;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 2];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++)
			dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
	}
}