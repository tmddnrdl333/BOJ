package bj_0124;

import java.util.Arrays;
import java.util.Scanner;

public class bj1015_0124 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		sc.close();

		// A를 정렬한 B배열과, 결과가 입력될 P배열
		int[] B = new int[N];
		for (int i = 0; i < N; i++)
			B[i] = A[i];
		Arrays.sort(B);
		int[] P = new int[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i] == B[j]) {
					B[j] = 0;
					P[i] = j;
					break;
				}
			}
		}
		for (int i = 0; i < N; i++)
			System.out.printf("%d ", P[i]);
	}
}
