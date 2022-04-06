package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,640kb
// 76ms

public class Main_2011_암호코드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int len = str.length();

		if (str.charAt(0) == '0') {
			bw.write("0");
			bw.flush();
			bw.close();
			return;
		}

		int[] arr = new int[len + 1];
		for (int i = 0; i < len; i++)
			arr[i + 1] = str.charAt(i) - '0';
		long[] dp = new long[len + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= len; i++) {
			if (arr[i] != 0)
				dp[i] = dp[i - 1];

			if (arr[i - 1] == 1 || arr[i - 1] == 2 && arr[i] <= 6)
				dp[i] = (dp[i] + dp[i - 2]) % 1000000;

		}

		bw.write(Long.toString(dp[len]));
		bw.flush();
		bw.close();
	}
}