package IM_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj19_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] inp = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			inp[i][0] = Integer.parseInt(st.nextToken());
			inp[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] stu = new int[6][2];
		for (int i = 0; i < N; i++) {
			int y = inp[i][0];
			int x = inp[i][1] - 1;
			stu[x][y]++;
		}
		// stu 는 학년별로 남녀 수를 알려줌
		// 1학년~6학년순, 여0남1
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += (stu[i][0] + K - 1) / K;
			sum += (stu[i][1] + K - 1) / K;
		}
		System.out.println(sum);
	}
}
