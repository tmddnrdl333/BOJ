package bj_0126;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj1159_0126 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] name = new char[N];

		for (int i = 0; i < N; i++) {
			name[i] = sc.next().charAt(0); // 입력과 동시 첫 글자만 차곡차곡 저장
		}
		sc.close();

		int[] cnt = new int[N]; // 각 인덱스에 해당 알파벳이 몇 개 있는지 저장할 배열
		boolean flag = false; // 아무도 없으면 그대로 false, PREDAJA 출력할 목적
		ArrayList<Character> cl = new ArrayList<>(); // 가변길이 배열, 답 되는 알파벳 모두 넣어줄 것
		for (int i = 0; i < N; i++) {
			cnt[i]++; // 하나니까 세주고
			if (cnt[i] == 0) // 만약 뒤에서 스킵하라고 한 놈이면 건너뛰기
				continue;
			for (int j = i + 1; j < N; j++) {
				if (name[i] == name[j]) {
					cnt[i]++; // 한칸 뒤부터 끝까지, 같은 놈 나올 때마다 +1하고,
					cnt[j] = -1; // 대신 그 같은 대상은 -1 저장해서 나중에 자기 차례 땐 건너뛰게
				}
			}
			if (cnt[i] > 4) {
				cl.add(name[i]); // 5명 이상이면 출전 가능, 가변길이 배열에 하나씩 넣어주기
				flag = true; // 한명이 이미 출전 가능이니까, PREDAJA 출력하지말자
			}
		}
		if (flag == false)
			System.out.println("PREDAJA"); // 아무도 출전 못하니까 항복
		else {
			Collections.sort(cl); // 사전순으로 자동정렬
			for (int i = 0; i < cl.size(); i++)
				System.out.print(cl.get(i));
		}
	}
}
