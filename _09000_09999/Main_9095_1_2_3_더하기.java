package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,572kb
// 76ms

public class Main_9095_1_2_3_더하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int[] inp = new int[T];
		int max = 0;
		for (int i = 0; i < T; i++) {
			int tmp = Integer.parseInt(br.readLine());
			inp[i] = tmp;
			max = tmp > max ? tmp : max;
		}

		int[] dp = new int[max + 2];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= max; i++)
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];

		for (int i = 0; i < T; i++)
			sb.append(dp[inp[i]]).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}