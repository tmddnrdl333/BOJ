package study.day0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// 24,412kb
// 276ms

public class study_boj_11286_절댓값_힙 {
	static class myInt implements Comparable<myInt> {
		int num;

		public myInt(int num) {
			this.num = num;
		}

		@Override
		public int compareTo(myInt o) {
			int thisAbs = Math.abs(this.num);
			int oAbs = Math.abs(o.num);
			return thisAbs == oAbs ? this.num - o.num : thisAbs - oAbs;
		}

		@Override
		public String toString() {
			return Integer.toString(num);
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		PriorityQueue<myInt> pq = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input != 0) {
				pq.add(new myInt(input));
			} else { // 0 : 절댓값 가장 작은 값 출력, 배열에서 제거
				if (pq.peek() == null)
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
