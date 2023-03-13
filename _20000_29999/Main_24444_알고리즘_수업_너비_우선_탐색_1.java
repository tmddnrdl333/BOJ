package ps.BOJ._20000_29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 118,836kb
// 1,144ms

public class Main_24444_알고리즘_수업_너비_우선_탐색_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] visit = new int[N];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			List<Integer> list = map.getOrDefault(a, new ArrayList<>());
			list.add(b);
			map.put(a, list);
			list = map.getOrDefault(b, new ArrayList<>());
			list.add(a);
			map.put(b, list);
		}

		for (int p : map.keySet())
			Collections.sort(map.get(p));

		int cnt = 1;

		Queue<Integer> q = new LinkedList<>();
		visit[R - 1] = cnt++;
		q.add(R - 1);

		while (!q.isEmpty()) {
			int ptr = q.poll();
			List<Integer> list = map.get(ptr);
			for (int p : list) {
				if (visit[p] != 0)
					continue;
				visit[p] = cnt++;
				q.add(p);
			}
		}

		for (int i = 0; i < N; i++)
			sb.append(visit[i]).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}