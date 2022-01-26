package bj_0126;

import java.util.Scanner;

public class bj1110_0126 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int res = 0; // 반복 횟수 저장할 변수
		final int origin = n; // 원래 값 저장
		do {
			res++;
			n = n % 10 * 10 + (n % 10 + n / 10) % 10; // 결과 수의 십의 자리: 원래 일의 자리. 일의자리: 더한 수의 일의자리
		} while (n != origin); // 같아질 때가지 계속
		System.out.println(res);
	}
}
