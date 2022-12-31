package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 51,312kb
// 168ms

public class Main_8394_악수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10;
		}

		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
	}

}
