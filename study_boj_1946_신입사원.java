package study.day0222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 298,200kb
// 888ms

public class study_boj_1946_신입사원 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static StringBuilder sb = new StringBuilder();

	static int[] person;
	static int N;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			person = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				person[b - 1] = a;
			}
			int cnt = 1;
			int min = person[0];
			for (int i = 0; i < N; i++) {
				if (person[i] < min) {
					min = person[i];
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}





















