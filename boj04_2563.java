package IM_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj04_2563 {
	public static void main(String[] args) throws IOException {
		int[][] map = new int[101][101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] inp = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			inp[i][0] = Integer.parseInt(st.nextToken());
			inp[i][1] = Integer.parseInt(st.nextToken());
		}
		//
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int x = inp[i][0];
			int y = inp[i][1];
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (map[x + j][y + k] == 0) {
						cnt++;
					}
					map[x + j][y + k] = 1;
				}
			}
		}
		System.out.println(cnt);

	}
}
