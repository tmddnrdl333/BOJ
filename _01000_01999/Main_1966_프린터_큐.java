package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 18,188kb
// 244ms

public class Main_1966_프린터_큐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (; TC > 0; TC--) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				q.add(tmp);
				pq.add(tmp);
			}

			int cnt = 0;
			while (true) {
				if (q.peek() != pq.peek()) {
					// q 앞을 뽑아 뒤로 넣기
					q.add(q.poll());
					// 인덱스 정리
					if (M == 0)
						M = q.size() - 1;
					else
						M--;
				} else {
					// cnt번째 출력
					cnt++;
					// q 앞을 프린트
					q.poll();
					// pq 최대값 하나 제거
					pq.poll();
					if (M == 0) {
						sb.append(cnt).append("\n");
						break;
					}
					M--;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}