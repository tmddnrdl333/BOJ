package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 23,296kb
// 216ms

public class Main_13398_연속합_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		// dp1: 왼쪽에서 오른쪽으로
		int[] dp1 = new int[n];
		dp1[0] = arr[0];

		int ans = dp1[0];

		for (int i = 1; i < n; i++) {
			dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);
			ans = Math.max(ans, dp1[i]);
		}

		// dp2: 오른쪽에서 왼쪽으로
		int[] dp2 = new int[n];
		dp2[n - 1] = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
		}

		// i번째를 제거한다고 치면... dp1+dp2로 구할 수 있음.
		for (int i = 1; i < n - 1; i++) {
			int tmp = dp1[i - 1] + dp2[i + 1];
			ans = Math.max(ans, tmp);
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}