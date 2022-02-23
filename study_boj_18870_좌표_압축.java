package study.day0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 271,284kb
// 1,652ms

public class study_boj_18870_좌표_압축 {

	static class Xs implements Comparable<Xs> {
		int idx, num;

		public Xs(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}

		@Override
		public int compareTo(Xs o) {
			if (num > o.num)
				return 1;
			else if (num == o.num)
				return 0;
			else
				return -1;

		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		PriorityQueue<Xs> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			pq.add(new Xs(i, temp));
		}

		int[] output = new int[N];

		Integer past = null;
		int cnt = -1;
		do {
			Xs now = pq.poll();
			if (past == null || past != now.num)
				cnt++;
			output[now.idx] = cnt;
			past = now.num;
		} while (!pq.isEmpty());

		for (int i = 0; i < N; i++) {
			sb.append(output[i]).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
