package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 24,368kb
// 240ms

public class Main_1932_정수_삼각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][];
		for (int i = 1; i <= N; i++) {
			arr[i] = new int[i + 2];
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N + 1][];
		dp[1] = new int[3];
		dp[1][1] = arr[1][1];
		for (int i = 2; i <= N; i++) {
			dp[i] = new int[i + 2];
			for (int j = 1; j <= i; j++) {
				dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
			}
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			int cur = dp[N][i];
			max = cur > max ? cur : max;
		}
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
	}
}