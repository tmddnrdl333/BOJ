package ps.BOJ._20000_29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 217,052kb
// 1,788ms

public class Main_21924_도시_건설 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Road {
		int to, cost;

		Road(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		// N: 도시의 수
		// roadLists: 도로의 비용을 담은 list의 배열
		// M: 도로의 수
		// minEdge[]: 가장 가까운 정점과의 거리를 저장하는 배열
		// pq: 도로의 비용을 담은 pq
		// visited[]: 도시의 방문여부를 저장하는 배열
		// fullCost: 모든 도로 건설시 비용
		int N = Integer.parseInt(st.nextToken());
		@SuppressWarnings("unchecked")
		ArrayList<Road>[] roadLists = new ArrayList[N];
		for (int i = 0; i < N; i++)
			roadLists[i] = new ArrayList<>();
		int M = Integer.parseInt(st.nextToken());
		long[] minEdge = new long[N];
		PriorityQueue<Road> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
		Arrays.fill(minEdge, Long.MAX_VALUE);
		boolean[] visited = new boolean[N];
		long fullCost = 0;

		// roadLists에 도로 정보 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1,
					c = Integer.parseInt(st.nextToken());
			roadLists[a].add(new Road(b, c));
			roadLists[b].add(new Road(a, c));
			fullCost += c;
		}

		// result: MST(최소신장트리) 비용
		long result = 0;
		int cnt = 1;

		visited[0] = true;
		pq.addAll(roadLists[0]);

		while (!pq.isEmpty()) {
			Road r = pq.poll();
			if (visited[r.to])
				continue;
			pq.addAll(roadLists[r.to]);
			visited[r.to] = true;
			result += r.cost;
			cnt++;
			if (cnt == N)
				break;
		}

		if (cnt == N)
			bw.write(fullCost - result + "");
		else
			bw.write("-1");
		bw.flush();
		bw.close();
	}
}