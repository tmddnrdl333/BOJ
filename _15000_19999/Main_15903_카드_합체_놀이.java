package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 13,128kb
// 132ms

public class Main_15903_카드_합체_놀이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			pq.add(Long.parseLong(st.nextToken()));
		for (int i = 0; i < m; i++) {
			long a = pq.poll();
			long b = pq.poll();
			pq.add(a + b);
			pq.add(a + b);
		}

		long sum = 0;
		while (!pq.isEmpty())
			sum += pq.poll();

		bw.write(sum + "");
		bw.flush();
		bw.close();

	}
}