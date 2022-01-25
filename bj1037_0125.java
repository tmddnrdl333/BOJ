package bj_0125;

import java.util.Scanner;

public class bj1037_0125 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int min = 1000000;
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			min = (arr[i] < min) ? arr[i] : min;
			max = (arr[i] > max) ? arr[i] : max;
		}
		System.out.println(min * max);

	}
}