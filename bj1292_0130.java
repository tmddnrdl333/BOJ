package bj_0130;

import java.util.Scanner;

public class bj1292_0130 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		int cnt = 1;
		int sum = 0;
		for (int i = 1; i <= B; i++) {
			for (int j = 0; j < i; j++) {
				if (cnt >= A)
					sum += i;
				if (cnt >= B) {
					System.out.println(sum);
					return;
				}
				cnt++;
			}
		}
	}
}
