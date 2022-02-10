package IM_practice;

import java.util.Arrays;
import java.util.Scanner;

public class boj01_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] h = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			h[i] = sc.nextInt();
			sum += h[i];
		}
		Arrays.sort(h);
		int a = 0;
		int b = 0;
		outer: for (int i = 0; i < 8; i++) {
			int tsum = 0;
			for (int j = i + 1; j < 9; j++) {
				tsum = h[i] + h[j];
				if (sum - tsum == 100) {
					a = i;
					b = j;
					break outer;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i != a && i != b)
				System.out.println(h[i]);
		}

	}
}
