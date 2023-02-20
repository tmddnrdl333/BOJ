package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,592kb
// 80ms

public class Main_2579_계단_오르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N + 2];
		for (int i = 1; i <= N; i++)
			score[i] = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 2];
		dp[1] = score[1];
		dp[2] = score[1] + score[2];
		for (int i = 3; i <= N; i++) {
			int a = dp[i - 2] + score[i];
			int b = dp[i - 3] + score[i - 1] + score[i];
			dp[i] = a > b ? a : b;
		}

		bw.write(dp[N] + "");
		bw.flush();
		bw.close();

	}
}