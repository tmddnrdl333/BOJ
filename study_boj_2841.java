package study.day0208;

import java.util.Scanner;
import java.util.Stack;

public class study_boj_2841 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		@SuppressWarnings("unused")
		int P = sc.nextInt();
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = sc.nextInt();
			arr2[i] = sc.nextInt();
		}
		sc.close();
		// 계산
		int cnt = 0;
		for (int i = 1; i <= 6; i++) {//
			Stack<Integer> st = new Stack<>();
			for (int j = 0; j < N; j++) {
				if (arr1[j] == i) {
					if (st.isEmpty()) {
						st.push(arr2[j]);
						cnt++;
					} else if (st.peek() < arr2[j]) {
						st.push(arr2[j]);
						cnt++;
					} else if (st.peek() == arr2[j]) {
						continue;
					} else {
						st.pop();
						cnt++;
						j--;
					}
				}
			}
		} //
		System.out.println(cnt);

	}
}
