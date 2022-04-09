package ps_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,152kb
// 88ms

public class Main_1149_RGB거리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][3];

		dp[1][0] = arr[1][0];
		dp[1][1] = arr[1][1];
		dp[1][2] = arr[1][2];

		for (int i = 2; i <= N; i++) {
			dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		bw.write(Integer.toString(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]))));
		bw.flush();
		bw.close();
	}
}