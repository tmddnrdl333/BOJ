package bj_0125;

import java.util.Scanner;

public class bj1085_0125 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		int min1 = ((arr[2] - arr[0]) < arr[0]) ? (arr[2] - arr[0]) : arr[0];
		int min2 = ((arr[3] - arr[1]) < arr[1]) ? (arr[3] - arr[1]) : arr[1];
		System.out.printf("%d", min1 < min2 ? min1 : min2);

	}
}
