package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 337,904kb
// 748ms

public class Main_15486_퇴사_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 2];
		int lastDay = N + 1;
		for (int i = N; i > 0; i--) {
			if (arr[i][0] <= lastDay - i) {
				lastDay = i;
				dp[i] = dp[i + 1] + arr[i][1];
			} else {
				if (i + arr[i][0] <= N + 1) {
					int temp = arr[i][1] + dp[i + arr[i][0]];
					if (temp > dp[i + 1]) {
						dp[i] = temp;
						lastDay = i;
					} else {
						dp[i] = dp[i + 1];
					}
				} else {
					dp[i] = dp[i + 1];
				}
			}
		}

//		System.out.println(Arrays.toString(dp));

		bw.write(Integer.toString(dp[1]));
		bw.flush();
		bw.close();
	}
}