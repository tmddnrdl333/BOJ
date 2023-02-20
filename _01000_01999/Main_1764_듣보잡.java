package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

// 25,824kb
// 244ms

public class Main_1764_듣보잡 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(br.readLine());

		PriorityQueue<String> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (set.contains(str))
				pq.add(str);
		}
		StringBuilder sb = new StringBuilder();
		String cl = "\n";
		sb.append(pq.size()).append(cl);
		while (!pq.isEmpty())
			sb.append(pq.poll()).append(cl);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
