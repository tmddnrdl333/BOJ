package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,592kb
// 76ms

public class Main_17271_리그_오브_레전설_Small {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] dp = new int[N + 1];
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i - 1];
			if (i < M)
				continue;
			dp[i] = (dp[i] + dp[i - M]) % 1000000007;
		}

		bw.write(dp[N] + "");
		bw.flush();
		bw.close();

	}
}