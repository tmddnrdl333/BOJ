package IM_practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class boj02_2605 {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			list.add(sc.nextInt(), i);
		}
		sc.close();
		for (int i = 0; i < N; i++)
			System.out.print(list.get(N - i - 1) + " ");
	}
}
