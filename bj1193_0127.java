package bj_0127;

import java.util.Scanner;

public class bj1193_0127 {
	public static void main(String[] args) {
//	11 12 21 31 22 13 14 23 32 41 51 42 33 24 15
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		sc.close();
		/**
		 * 11 / 12 21 / 31 22 13 / 14 23 32 41 / 51 ... 이렇게 합이 같은 수를 한 행에 놓는다고 할 때,
		 */
		int nri = 1; // 다음 행의 첫 인덱스
		int row = 0; // 이번 행의 분수 개수 (row+1은 분수 이루는 두 수의 합)
		while (nri <= X) {
			row++;
			nri += row;
		}
		int ri = nri - row; // 이번 행의 첫 인덱스
		int Xidx = X - ri; // X가 이번 행 몇 번째인지 (0=첫번째)
		if (row % 2 != 0) {
			System.out.println((row - Xidx) + "/" + (Xidx + 1));
		} else {
			System.out.println((Xidx + 1) + "/" + (row - Xidx));
		}

	}
}
