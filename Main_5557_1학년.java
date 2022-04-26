package study.day0426;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,644kb
// 76ms

public class Main_5557_1학년 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		long[][] count = new long[N - 1][21];

		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		count[0][first] = 1;
		for (int i = 1; i < N - 1; i++) {
			int cur = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 21; j++) {
				if (count[i - 1][j] != 0) {
					if (j + cur <= 20)
						count[i][j + cur] += count[i - 1][j];
					if (j - cur >= 0)
						count[i][j - cur] += count[i - 1][j];
				}
			}
		}

		int sum = Integer.parseInt(st.nextToken());
		long res = count[N - 2][sum];
		bw.write(Long.toString(res));
		bw.flush();
		bw.close();
	}
}