package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 23,272kb
// 128ms

public class Main_12851_숨바꼭질_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int time = 0;
		visited[N] = time;
		int cnt = 0;
		boolean flag = false;
		while (!q.isEmpty() && !flag) {
			int size = q.size();
			time++;
			for (; size != 0; size--) {
				int cur = q.poll();
				if (cur == K) {
					cnt++;
					flag = true;
					continue;
				}
				if (cur < K) {
					if (cur + 1 < 100001 && (visited[cur + 1] == 0 || visited[cur + 1] == time)) {
						visited[cur + 1] = time;
						q.add(cur + 1);
					}
					if (cur * 2 < 100001 && (visited[cur * 2] == 0 || visited[cur * 2] == time)) {
						visited[cur * 2] = time;
						q.add(cur * 2);
					}
				}
				if (cur > 3 || cur > K)
					if (visited[cur - 1] == 0 || visited[cur - 1] == time) {
						visited[cur - 1] = time;
						q.add(cur - 1);
					}
			}
		}
//		for (int i = 0; i < K + 2; i++)
//			System.out.println(i + " " + visited[i]);
		sb.append(time - 1).append("\n").append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}