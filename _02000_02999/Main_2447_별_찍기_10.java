package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 59,524kb
// 476ms

public class Main_2447_별_찍기_10 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ap(i, j, N);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void ap(int i, int j, int n) {
		if (n == 3) {
			if (i % 3 == 1 && j % 3 == 1)
				sb.append(" ");
			else
				sb.append("*");
			return;
		}
		i %= n;
		j %= n;
		if (i >= n / 3 && i < n / 3 * 2 && j >= n / 3 && j < n / 3 * 2)
			sb.append(" ");
		else
			ap(i, j, n / 3);
	}
}