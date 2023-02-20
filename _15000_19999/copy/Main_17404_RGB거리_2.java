package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,328kb
// 96ms

public class Main_17404_RGB거리_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static final int INF = 987654321;
	static int res = INF;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N + 1][3];

		for (int i = 0; i < 3; i++) {
			dp[N][0] = INF;
			dp[N][1] = INF;
			dp[N][2] = INF;
			// 1번 줄에서 i번째 색을 선택했을 때의 최대값을 계산해보자

			// 1번줄은 i만 넣어주고 나머지는 0을 넣어서 i를 고를 수 밖에 없도록
			dp[1][i] = input[1][i];
			for (int j = 0; j < 3; j++) {
				if (i != j)
					dp[1][j] = INF;
			}

			// 2번줄부터 N-1줄까지 dp로 고르기
			for (int j = 2; j <= N; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + input[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + input[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + input[j][2];
			}
			dp[N][i] = INF;

			res = Math.min(res, Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		}

		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();

	}
}