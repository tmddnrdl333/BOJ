package study.day0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,240kb
// 464ms

public class study_boj_1052_물병 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, K, buy;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 비어있지 않은 물병의 개수
		K = Integer.parseInt(st.nextToken()); // 목표 비어있지 않은 물병의 개수
		// 입력 끝
		buy = 0;

		while (true) {
			int cnt = 0;
			for (int i = 0; i < 30; i++) {
				if ((N & 1 << i) != 0)
					cnt++;
			}
			if (cnt <= K) {
				bw.write(Integer.toString(buy));
				bw.flush();
				bw.close();
				return;
			}
			buy++;
			N++;
		}
	}
}
