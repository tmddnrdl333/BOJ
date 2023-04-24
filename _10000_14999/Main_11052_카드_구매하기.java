package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,984kb
// 100ms

public class Main_11052_카드_구매하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] dp = new int[N + 1];
		dp[1] = arr[1];
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i] = Math.max(arr[j] + dp[i - j], dp[i]);
			}
		}

		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
	}
}