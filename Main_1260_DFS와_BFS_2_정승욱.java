package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2. 인접 리스트 : Node 클래스를 만들어서 구현

public class Main_1260_DFS와_BFS_2_정승욱 {

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static boolean[] visit;
	static Node[] adjList;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()) - 1;

		adjList = new Node[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
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

		Node child = adjList[cur];
		while (true) {
			if (child == null)
				break;
			if (!visit[child.vertex])
				dfs(child.vertex);
			child = child.link;
		}
	}

	// 주의 : 우선순위는 고려하지 못했음
	public static void bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		visit[cur] = true;
		q.add(cur);
		Node child = adjList[cur];
		while (!q.isEmpty()) {
			while (child != null) {
				if (!visit[child.vertex]) {
					visit[child.vertex] = true;
					q.add(child.vertex);
				}
				child = child.link;
			}
			child = adjList[q.peek()];
			sb.append(q.poll() + 1).append(" ");
		}

	}
}
