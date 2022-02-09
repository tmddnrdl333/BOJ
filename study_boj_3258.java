package study.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study_boj_3258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Z = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 맵 : i=1 시작, 끝은 i=N대신 i=0
		int[] map = new int[N];
		map[Z % N] = 2;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			map[Integer.parseInt(st.nextToken())] = 1;
		}
		// 2는 도착지, 1은 장애물
		//
		for (int i = 1; i < Z; i++) {
			int now = 1;

			while (now != Z) {
				now = (now + i) % N;
				if (map[now] == 1) {
					break;
				} else if (map[now] == 2) {
					System.out.println(i);
					return;
				}
				if (now == 1) // 무한반복 시간초과 방지
					break;
			}
		}
	}
}
