package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 22,576kb
// 200ms

public class Main_1912_연속합2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[N + 1];

		dp[1] = arr[1];

		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			max = dp[i] > max ? dp[i] : max;
		}

		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();

	}
}