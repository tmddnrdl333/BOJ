package study.day0216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// 24,780kb
// 376ms

public class study_boj_1715_카드_정렬하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int cumul = 0;
		while (!pq.isEmpty()) {
			int temp1 = pq.poll();
			int temp2 = 0;
			if (!pq.isEmpty()) {
				temp2 = pq.poll();
			} else {
				break;
			}
			cumul += temp1 + temp2;
			pq.add(temp1 + temp2); // 가장 작은 두 개 더하기
		}
		System.out.println(cumul);
	}
}
