package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,604kb
// 76ms

public class Main_9461_파도반_수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		int max = 0;
		for (int i = 0; i < T; i++) {
			int inp = Integer.parseInt(br.readLine());
			max = inp > max ? inp : max;
			arr[i] = inp;
		}

		long[] dp = new long[max + 5];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for (int i = 6; i <= max; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}

		for (int i = 0; i < T; i++) {
			sb.append(dp[arr[i]]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}