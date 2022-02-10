package study.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_boj_1522 {
	static int[] nArr;
	static int len;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		len = arr.length;
		nArr = new int[len];

		// 숫자로 바꾸고 a 개수 카운팅
		int a = 0;
		for (int i = 0; i < len; i++) {
			nArr[i] = (int) arr[i] - 'a';
			if (nArr[i] == 0)
				a++;
		}
		// 슬라이딩윈도우
		// a개수만큼 큰 칸을 움직이며 b개수 최소인 칸을 찾음
		int min = 0;
		for (int i = 0; i < a; i++) {
			min += nArr[i];
		}
		int window = min;
		for (int i = 0; i < len - 1; i++) {
			window = window - nArr[i] + nArr[(i + a) % len];
			min = window < min ? window : min;
		}
		System.out.println(min);

	}
}
