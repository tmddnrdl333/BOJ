package bj_0130;

import java.util.Scanner;

public class bj1316_0130 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = N;
		String[] str = new String[N];
		for (int i = 0; i < N; i++)
			str[i] = sc.next();
		sc.close();
		// 몇 번 스트링
		lp: for (int i = 0; i < N; i++) {
			int len = str[i].length();
			// 각 스트링 첫 글자부터
			for (int j = 0; j < len - 1; j++) {
				// 현재 검사할 문자
				char jthChar = str[i].charAt(j);
				// 처음으로 다른 문자가 나오는 인덱스 (디폴트는 다음 문자)
				int firstDiff = j + 1;
				// 그걸 찾기 위한 포문
				for (int k = j + 1; k < len; k++) {
					if (str[i].charAt(k) != jthChar) {
						break;
					}
					firstDiff++;
				}
				// 첫 다른 글자부터 또 같은 문자가 나오는지
				for (int l = firstDiff; l < len; l++) {
					if (jthChar == str[i].charAt(l)) {
						res--;
						continue lp;
					}
				}
			}
		}
		System.out.println(res);

	}
}
