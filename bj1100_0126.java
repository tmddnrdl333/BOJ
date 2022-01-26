package bj_0126;

import java.util.Scanner;

public class bj1100_0126 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = sc.next();
		}
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (arr[i].charAt(j) == 'F' && (i + j) % 2 == 0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		sc.close();

	}
}
