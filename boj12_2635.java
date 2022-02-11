package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 18904kb
// 128ms

public class boj12_2635 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringBuilder maxsb = new StringBuilder();

		int max = 0;
		for (int i = N / 2 + 1; i <= N; i++) {
			int n = N, m = i;
			sb.append(n + " ").append(m);
			int cnt = 2;
			while (true) {
				int next = n - m;
				if (next >= 0) {
					sb.append(" " + next);
					n = m;
					m = next;
					cnt++;
				} else
					break;
			}
			if (cnt > max) {
				max = cnt;
				maxsb.setLength(0);
				maxsb.append(max + "\n" + sb);
			}
			sb.setLength(0);
		}
		bw.write(maxsb.toString());
		bw.flush();
		bw.close();
	}
}
