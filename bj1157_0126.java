package bj_0126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1157_0126 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력과 동시에 대문자화
		String str1 = br.readLine().toUpperCase();
		// 길이 구하는 함수 여러번 호출하지 말고 그냥 변수에 넣기
		final int len = str1.length();
		// 각 인덱스에 대응하는 알파벳 개수 기록 배열
		int[] arr = new int[len];

		// 기록 시작
		for (int i = 0; i < len; i++) {
			if (arr[i] == -1) // 건너뛰라고 적어놓은 -1이 맞다면 건너뛰기
				continue;
			arr[i]++; // 하나 카운트
			for (int j = i + 1; j < len; j++) {
				// 그 다음 번부터 끝까지, 일치할때마다 +1
				if (str1.charAt(j) == str1.charAt(i)) {
					arr[i]++;
					arr[j] = -1; // 대신 일치한 대상은 -1로 건너뛰어주기
				}
			}
		}
		// 최대값 찾기
		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < len; i++) {
			if (arr[i] > max) {
				maxIdx = i; // 최대값이 발생한 인덱스
				max = arr[i]; // 최대값
			}
		}

		int check = 0; // 최대값 중복 확인
		for (int i = 0; i < len; i++) {
			if (arr[i] == max) {
				check++;
				if (check == 2) // 이미 2개면 더 볼 것 없다.
					break;
			}
		}
		if (check == 1)
			System.out.println(str1.charAt(maxIdx));
		else
			System.out.println("?");

	}
}
