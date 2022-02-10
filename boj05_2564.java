package IM_practice;

import java.util.Scanner;

public class boj05_2564 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int mapsize = 2 * w + 2 * h;
		int store = sc.nextInt();
		int[] st1 = new int[store];
		for (int i = 0; i < store; i++) {
			int s1 = sc.nextInt(); // 1북2남3서4동
			int s2 = sc.nextInt(); // 왼/위로부터 거리
			if (s1 == 1) { // 좌 상단 기준으로 펼치기
				st1[i] = s2;
			} else if (s1 == 2) {
				st1[i] = 2 * w + h - s2;
			} else if (s1 == 3) {
				st1[i] = 2 * w + 2 * h - s2;
			} else if (s1 == 4) {
				st1[i] = w + s2;
			}
		}
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		int dg = 0;
		if (d1 == 1) { // 좌 상단 기준으로 펼치기
			dg = d2;
		} else if (d1 == 2) {
			dg = 2 * w + h - d2;
		} else if (d1 == 3) {
			dg = 2 * w + 2 * h - d2;
		} else if (d1 == 4) {
			dg = w + d2;
		}
		sc.close();
		//
		int sum = 0;
		for (int i = 0; i < store; i++) {
			// 각 상점에 대한 최단거리 계산
			int s = st1[i];
			int tmp1 = Math.abs(dg - s);
			int tmp2 = mapsize - Math.max(dg, s) + Math.min(dg, s);
			sum += Math.min(tmp1, tmp2);
		}
		System.out.println(sum);
	}
}
