package ps.BOJ._04000_04999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_4097_수익 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			int max = Integer.MIN_VALUE;
			int sum = 0;

			for (int i = 1; i <= N; i++) {
				int inp = Integer.parseInt(br.readLine());
				sum += inp;
				max = sum > max ? sum : max;
				if (sum < 0)
					sum = 0;
			}
			sb.append(max + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}