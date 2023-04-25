package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 25,588kb
// 236ms

public class Main_9184_신나는_함수_실행 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1)
				break;
			sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int w(int a, int b, int c) {
		if (a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20 && dp[a][b][c] != 0)
			return dp[a][b][c];

		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		if (a > 20 || b > 20 || c > 20)
			return dp[20][20][20] = w(20, 20, 20);
		if (a < b && b < c)
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
}