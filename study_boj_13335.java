package study.day0208;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class study_boj_13335 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int L = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		// 계산
		int t = 0;
		int weight = 0;
		Queue<Integer> queue = new LinkedList<>();
		int i = 0;
		while (true) {
			// 내리기
			//
			if (queue.size() == w) {
//				System.out.println(queue.peek() + "내립니다.");
				weight -= queue.poll();
			}
			// 다음 다리에 오를 차,
			// 무게 가능이면 고, 안되면 0으로 밀어주기
			int next = 0;
			if (weight + a[i] <= L) {
				next = a[i];
			} else {
				i--; // 트럭 대기
			}
			weight += next;
			queue.offer(next); // 0 이라도 밀어넣기
//			System.out.println(next + "탑니다.");
			t++;

			i++;
			if (i == n)
				break;
//			System.out.println(" 현재:  " + queue);
		}

		System.out.println(t + w);
	}
}
