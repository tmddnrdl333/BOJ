package bj_0127;

import java.util.Scanner;

public class bj1233_0127 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();

		// 0번 - 3개수 , 1번 - 4개수 , ...
		int[] arr = new int[a + b + c - 2];

		for (int i = 0; i < a; i++)
			for (int j = 0; j < b; j++)
				for (int k = 0; k < c; k++)
					arr[i + j + k]++;

		int tmp = 0;
		for (int i = 0; i < (a + b + c - 2) / 2 + 1; i++)
			if (arr[i] >= arr[i + 1]) {
				tmp = i;
				break;
			}

		System.out.println(tmp + 3);

	}
}
