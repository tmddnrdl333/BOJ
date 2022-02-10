package IM_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj07_2477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		int[][] arr = new int[6][2]; // 1 2 3 4 동 서 남 북
		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if (arr[i][1] > max) {
				max = arr[i][1];
				maxIdx = i;
			}
		}
		int a = (maxIdx + 1) % 6;
		int b = (maxIdx + 5) % 6;
		int tmp = 0;
		if (arr[a][1] > arr[b][1]) {
			tmp = arr[a][1];
			b = -1;
		} else {
			tmp = arr[b][1];
			a = -1;
		}
		int big = arr[maxIdx][1] * tmp;
		if (b == -1) {
			a = (maxIdx + 3) % 6;
			b = (maxIdx + 4) % 6;
		} else {
			a = (maxIdx + 2) % 6;
			b = (maxIdx + 3) % 6;
		}
		int small = arr[a][1] * arr[b][1];
		System.out.println((big - small) * K);

	}
}
