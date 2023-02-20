package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 22,576kb
// 200ms

public class Main_1912_연속합 {
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
			if (arr[i] > 0)
				if (dp[i - 1] > 0)
					dp[i] = dp[i - 1] + arr[i];
				else
					dp[i] = arr[i];
			else {
				if (-arr[i] < dp[i - 1])
					dp[i] = dp[i - 1] + arr[i];
				else
					dp[i] = arr[i];
			}
			max = dp[i] > max ? dp[i] : max;
		}

		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();

	}
}