package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1. N*N 인접행렬

public class Main_1260_DFS와_BFS_1_정승욱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static boolean[][] adjArr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()) - 1;

		adjArr = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjArr[from][to] = true;
			adjArr[to][from] = true;
		}

		// 1. DFS
		visit = new boolean[N];
		dfs(V);

		sb.append("\n");

		// 2. BFS
		visit = new boolean[N];
		bfs(V);

		// 결과
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static void dfs(int cur) {
		visit[cur] = true;
		sb.append(cur + 1).append(" ");
		for (int i = 0; i < N; i++) {
			if (!visit[i] && adjArr[cur][i])
				dfs(i);
		}
	}

	public static void bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		visit[cur] = true;
		q.add(cur);
		while (!q.isEmpty()) {
			for (int i = 0; i < N; i++) {
				if (!visit[i] && adjArr[q.peek()][i]) {
					visit[i] = true;
					q.add(i);
				}
			}
			sb.append(q.poll() + 1).append(" ");
		}

	}
}
