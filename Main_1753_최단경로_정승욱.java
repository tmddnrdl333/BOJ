package algorithm_hw.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 117,376kb
// 692ms

public class Main_1753_최단경로_정승욱 {

	static class Vertex implements Comparable<Vertex> {
		int no, minDistance;

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static List<Vertex>[] adjList;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점 수
		int E = Integer.parseInt(st.nextToken()); // 간선 수
		int K = Integer.parseInt(br.readLine()) - 1; // 시작 정점 번호
		adjList = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new LinkedList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1; // from
			int v = Integer.parseInt(st.nextToken()) - 1; // to
			int w = Integer.parseInt(st.nextToken()); // 가중치
			adjList[u].add(new Vertex(v, w));
		}

		//
		int[] distance = new int[V]; // 출발지에서 자신으로 오는 최소비용을 저장하는 배열
		boolean[] visited = new boolean[V]; // 최소비용 확정여부
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0; // 시작점 K만 0이고 나머지 무한
		pQueue.offer(new Vertex(K, distance[K])); // 자기에게는 0

		while (!pQueue.isEmpty()) {
			// 단계1: 최소비용 확정되지 않은 정점 중 최소비용의 정점 선택
			Vertex current = pQueue.poll();

			if (visited[current.no])
				continue;
			visited[current.no] = true;

			// 단계2: 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			// 연결된 정점들 중
			// 방문하지 않았고,
			// 거리 더해도 최소일때 갱신해주자
			for (Vertex v : adjList[current.no]) {
				if (!visited[v.no] && distance[v.no] > distance[current.no] + v.minDistance) {
					distance[v.no] = distance[current.no] + v.minDistance;
					pQueue.offer(new Vertex(v.no, distance[v.no]));
				}
			}

		}
		for (int i = 0; i < V; i++) {
			int temp = distance[i];
			if (temp != Integer.MAX_VALUE)
				sb.append(distance[i]).append("\n");
			else
				sb.append("INF\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
