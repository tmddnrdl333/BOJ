package bj_0123;

import java.util.Scanner;

public class bj1124_0123 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();

		// underprime 개수 카운팅
		int cnt = 0;
		for (int i = A; i <= B; i++) {
			if (underprimeTest(i) == true)
				cnt++;
		}
		// 결과 출력
		System.out.println(cnt);

	}

	// 소수인지 아닌지 확인 (맞으면=true)
	static boolean primeTest(int num) {
		// 디폴트는 flag = true(소수가 맞다). 즉, 아래 테스트에서 걸리지 않으면 소수가 맞다는 논리.
		boolean flag = true;
		if (num < 2) { // 1은 소수 아님.
			flag = false;
		} else if (num != 2 && num % 2 == 0) { // 2가 아니면서 짝수면 소수아님.
			flag = false;
		} else if (num % 2 != 0) { // 2보다 큰 홀수에 관해
			for (int i = 3; i <= (int) Math.sqrt(num); i += 2) { // 3부터 루트num까지 차례로 모든 홀수를 나눠 나머지를 구함.
				if (num % i == 0) { // 나눠 떨어지는 순간 소수아님, 반복문 종료.
					flag = false;
					break;
				}
			}
		}
		// - 이 수는,
		// - (1) 2이거나,
		// - (2) (1이 아니면서 && 짝수도 아니면서 && 2보다 큰 홀수인데) && (자기 자신의 루트보다 작거나 같은 1아닌 모든 홀수에
		// 대해 나눠 떨어지지 않는다면)
		// - 그러면 flag = false를 거치지 않을 것이고, 따라서 디폴트인 true일 것이며 소수라고 할 수 있다.
		return flag;
	}

	static boolean underprimeTest(int N) {
		// 디폴트는 flag = false(언더프라임이 아니다). 즉, 아래 테스트를 통과하면 언더프라임이라고 인정해준다.
		boolean flag = false;
		// 소인수분해를 해서 소인수의 개수를 cnt로 카운팅함.
		int cnt = 0;
		// 본격 소인수분해
		for (int i = 2; i <= (int) Math.sqrt(N); i++) { // 소인수는 2부터 루트N사이에만 존재할 수 있음.
			if (primeTest(i) == false) // 만약 이번 회차 i가 소수가 아니면 다음 홀수 i로 건너뛰기.
				continue;
			if (N % i != 0) // 이번 회차 i는 소수가 맞긴 한데, 나눠 떨어지지 않는다면 다음으로 건너뛰기.
				continue;
			cnt++; // 두 건너뛰기에 해당안했으니 소수이면서 나눠 떨어진다는 뜻이므로 하나 추가.
			N = N / i; // + 소인수로 나눠주고,
			i = 1; // i는 처음부터 다시해야하니 초기화 해주고 다시 반복문 돌아감.
			// (i=1을 해줘야 반복문 돌아가면서 i++에 의해 i가 다시 2로 시작할 수 있음.)
		}
		cnt++; // 마지막 남은 N은 소수일 수 밖에 없으므로, 하나 더 세줌.
		// 본격 언더프라임 검사.
		// cnt가 소수여야만 언더프라임.
		if (primeTest(cnt) == true)
			flag = true;
		// 소인수 분해 결과 소인수 개수가 소수인 경우만 true를 반환.
		return flag;
	}
}
