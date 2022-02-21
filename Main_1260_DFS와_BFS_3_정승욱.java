package algorithm_ws.boj;

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

// 3. 인접 리스트 : ArrayList

public class Main_1260_DFS와_BFS_3_정승욱 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static boolean[] visit;
	static List<Integer>[] adjList;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()) - 1;

		adjList = new List[N];
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjList[from].add(to);
			adjList[to].add(from);

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

	// 주의 : 우선순위는 고려하지 못했음
	public static void dfs(int cur) {
		visit[cur] = true;
		sb.append(cur + 1).append(" ");

		for (int i = 0; i < adjList[cur].size(); i++) {
			int idx = adjList[cur].get(i);
			if (!visit[idx]) {
				visit[idx] = true;
				dfs(idx);
			}
		}
	}

	// 주의 : 우선순위는 고려하지 못했음
	public static void bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		visit[cur] = true;
		q.add(cur);
		while (!q.isEmpty()) {
			for (int i = 0; i < adjList[cur].size(); i++) {
				int idx = adjList[cur].get(i);
				if (!visit[idx]) {
					visit[idx] = true;
					q.add(idx);
				}
			}
			cur = q.peek();
			sb.append(q.poll() + 1).append(" ");
		}

	}
}
