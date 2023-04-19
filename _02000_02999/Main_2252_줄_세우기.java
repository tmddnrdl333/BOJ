package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 50,644kb
// 432ms

public class Main_2252_줄_세우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<Integer>> list = new ArrayList<>();
		int[] edgeCnt = new int[N + 1];
		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			edgeCnt[b]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			if (edgeCnt[i] == 0)
				q.add(i);

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + " ");

			for (int target : list.get(cur))
				if (--edgeCnt[target] == 0)
					q.add(target);

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}