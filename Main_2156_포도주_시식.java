package ps_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 13,212kb
// 104ms

public class Main_2156_포도주_시식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		dp[1] = arr[1];
		if (n > 1)
			dp[2] = arr[1] + arr[2];
		if (n > 2)
			dp[3] = Math.max(dp[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], Math.max(dp[i - 2] + arr[i], dp[i - 1]));
		}
		bw.write(Integer.toString(dp[n]));
		bw.flush();
		bw.close();
	}
}