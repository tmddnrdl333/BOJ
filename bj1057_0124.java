package bj_0124;

import java.util.Scanner;

public class bj1057_0124 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();

		int cnt = 0;
		while (N != 1) {
			cnt++;
			N = (int) Math.ceil((float) N / 2);
			A = (A + 1) / 2;
			B = (B + 1) / 2;
			if (A == B)
				break;
		}
		System.out.println(cnt);
	}
}