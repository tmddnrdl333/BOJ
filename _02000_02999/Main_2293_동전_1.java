package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 15,820kb
// 96ms

public class Main_2293_동전_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n, k;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		// 동적 테이블
		// 행 : 고려할 동전 가짓수
		// 열 : 만들 액수
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++)
			dp[i][0] = 1;

		int ith = 0;
		for (int i = 1; i <= n; i++) {
			ith = arr[i];
			for (int j = 1; j <= k; j++) {
				// i번째 동전까지 고려했을 때, j원을 만들 수 있는 가짓수
				// i-1번째 동전까지로 j원을 만들 수 있는 가짓수 + i번째 동전 가능하면 하나 추가
				if (j >= ith)
					dp[i][j] = dp[i - 1][j] + dp[i][j - ith];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		bw.write(Integer.toString(dp[n][k]));
		bw.flush();
		bw.close();

	}
}