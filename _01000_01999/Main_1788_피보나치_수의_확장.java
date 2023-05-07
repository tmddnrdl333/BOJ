package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 16,884kb
// 96ms

public class Main_1788_피보나치_수의_확장 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static final int MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		if (n > 0) {
			sb.append("1\n");
			int[] fi = new int[n + 1];
			fi[1] = 1;
			for (int i = 2; i <= n; i++)
				fi[i] = (fi[i - 2] + fi[i - 1]) % MOD;
			sb.append(fi[n]);
		} else if (n == 0)
			sb.append("0\n0");
		else {
			int[] fi = new int[-n + 1];
			fi[1] = 1;
			for (int i = 2; i <= -n; i++)
				fi[i] = (fi[i - 2] - fi[i - 1]) % MOD;
			if (fi[-n] > 0)
				sb.append("1\n" + fi[-n]);
			else if (fi[-n] == 0)
				sb.append("0\n");
			else
				sb.append("-1\n" + (-fi[-n]));
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}