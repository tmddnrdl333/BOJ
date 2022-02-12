package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11848kb
// 76ms

public class boj13_1244 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 스위치 수
		int[] sw = new int[N + 1]; // 1 인덱스부터 N까지
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		int stu = Integer.parseInt(br.readLine());
		for (int i = 0; i < stu; i++) {
			st = new StringTokenizer(br.readLine());
			int bg = Integer.parseInt(st.nextToken()); // 남녀
			int num = Integer.parseInt(st.nextToken()); // 받은 번호
			if (bg == 1) {
				for (int j = num; j <= N; j += num) {
					sw[j] = 1 - sw[j]; // 반전
				}
			} else {
				int cnt = 0;
				for (int j = 1; j <= N / 2; j++) {
					if (num + j == N + 1 || num - j == 0)
						break;
					if (sw[num + j] == sw[num - j])
						cnt++;
					else
						break;
				}
				for (int j = num - cnt; j <= num + cnt; j++) {
					sw[j] = 1 - sw[j];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(sw[i] + " ");
			if (i % 20 == 0)
				sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
