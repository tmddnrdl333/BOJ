package bj_0127;

import java.util.Scanner;

public class bj1225_0127 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		sc.close();

		int Alen = A.length();
		int Blen = B.length();

		int[] Aa = new int[Alen];
		int[] Ba = new int[Blen];

		for (int i = 0; i < Alen; i++) {
			Aa[i] = A.charAt(i) - '0';
		}
		for (int i = 0; i < Blen; i++) {
			Ba[i] = B.charAt(i) - '0';
		}

		long res = 0;
		for (int i = 0; i < Alen; i++) {
			for (int j = 0; j < Blen; j++) {
				res += (long) Aa[i] * Ba[j];
			}
		}

		System.out.println(res);

	}
}
