package IM_practice;

import java.util.Scanner;

public class boj03_2578 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int[][] posi = new int[25][2];
		int[][] map = new int[5][5];
		for (int i = 0; i < 25; i++) {
			int tmp = sc.nextInt();
			posi[tmp - 1][0] = i / 5;
			posi[tmp - 1][1] = i % 5;
		} // 숫자별 위치 저장 완료
		for (int i = 0; i < 25; i++) {
			int tmp = sc.nextInt();
			int r = posi[tmp - 1][0];
			int c = posi[tmp - 1][1];
			map[r][c] = 1;
			int bingo = 0;
			if (i >= 11) { // 12번째 부터 빙고 가능 (5 4 3)
				int sum1 = 0;
				int sum2 = 0;
				for (int j = 0; j < 5; j++) {
					int rsum = 0;
					int csum = 0;
					sum1 += map[j][j];
					sum2 += map[j][4 - j];
					for (int k = 0; k < 5; k++) {
						rsum += map[j][k];
						csum += map[k][j];
					}
					if (rsum == 5) {
						bingo++;
					}
					if (csum == 5) {
						bingo++;
					}
					if (sum1 == 5) {
						bingo++;
					}
					if (sum2 == 5) {
						bingo++;
					}
				}
			}
			if (bingo >= 3) {
				System.out.println(i + 1);
				sc.close();
				return;
			}

		}

	}
}
