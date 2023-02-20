package ps.BOJ._04000_04999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 13,348kb
// 124ms

public class Main_4344_평균은_넘겠지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			double sum = 0;
			double[] arr = new double[N];
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				sum += cur;
				arr[j] = cur;
			}
			double avg = sum / N;
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (arr[j] > avg) {
					cnt++;
				}
			}
			double perc = (double) cnt / N * 100;
			System.out.printf("%.3f%c\n", perc, '%');
		}
	}
}