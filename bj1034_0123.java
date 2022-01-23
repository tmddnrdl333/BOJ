package bj_0123;

import java.util.Scanner;

public class bj1034_0123 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] arr = new String[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.next();
		int K = sc.nextInt();
		sc.close();

		// 입력 분석

		// 1. sameRow 배열 선언, 초기화
		// - 똑같은 행들을 찾아서 개수를 기록하는 배열
		// - ex) 1행2행이 같고 3행4행이 같고 5행은 혼자라면
		// [2, 0, 2, 0, 1]이 됨.
		int[] sameRow = new int[N];
		for (int i = 0; i < N; i++) { // 우선 1로 초기화하고,
			sameRow[i] = 1;
		}
		for (int i = 0; i < N; i++) { // 입력 배열의 각 i번 행에 대해서,
			if (sameRow[i] != 0) {
				for (int j = i + 1; j < N; j++) { // j번 행과 같은지 검사하고,
					if (arr[i].equals(arr[j]) == true) {
						sameRow[i]++; // 같다면 sameRow에 추가해주고,
						sameRow[j] = 0; // 그 같게된 대상은 이제 카운팅 안한단 의미로 0. 그래서 4줄 위 if가 있는 것임.
					}
				}
			}
		}

		// 2. cnt0 배열
		// - sameRow에서 0 아닌 인덱스별로 각 행에 0이 몇개인지 받는 배열
		// - 각 행별로 0이 몇개있는지 알아야 몇 번 스위치를 눌러야 하는지 알 수 있기 때문.
		int[] cnt0 = new int[N];
		for (int i = 0; i < N; i++) {
			if (sameRow[i] != 0) { // sameRow 만들 때 0은 카운팅하지 않기로 했기 때문.
				for (int j = 0; j < M; j++) {
					if (arr[i].charAt(j) == '0') {
						cnt0[i]++; // 결과적으로, 세야하는 행에 대해서만 0이 몇개인지 세서 cnt0배열에 넣기.
					}
				}
			}
		}

		// 3. K가 유효한지 검사, 동시에 몇줄 켜지는지 최대값 세기.
		// - 앞서 cnt0이 핵심이고,
		// - cnt0가 가리키는 어떤 행의 0 개수보다 K가 작다면, 그 행은 절대 다 킬 수 없음.
		// - 똑같다면, 딱 다 킬 수 있음. (카운트)
		// - K가 더 크면서, 그 차이가 짝수여야 가능. (카운트) (아래에서 tmp변수가 그 차이)
		// - - 홀수라면 불필요한 스위치 조작 때문에 불이 꺼짐. 짝수면 임의의 열 껐다키기.
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (sameRow[i] != 0) { // sameRow 만들 때 0은 카운트 하지 않는 거였음.
				int tmp = K - cnt0[i];
				if (tmp >= 0) { // 0이면 딱뎀. 그 이상이면 짝수인지 고려.
					if (tmp % 2 == 0) { // 짝수 첵.
						max = (sameRow[i] > max) ? sameRow[i] : max;
					}
				}
			}
		}
		System.out.println(max);

	}

}
