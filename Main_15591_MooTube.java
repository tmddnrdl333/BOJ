package study.day0308;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 49,868kb
// 1,860ms

public class Main_15591_MooTube {

	static class Node {
		int i;
		List<int[]> adj;

		Node(int i, List<int[]> adj) {
			this.i = i;
			this.adj = adj;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, Q;
	static Node[] nodes;
	static int K, cnt;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i, new ArrayList<int[]>());
		}
		Q = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			// pi qi ri 연결 정보 입력받음
			int pi = Integer.parseInt(st.nextToken()) - 1;
			int qi = Integer.parseInt(st.nextToken()) - 1;
			int ri = Integer.parseInt(st.nextToken());
			// 간선 리스트로 바꿔서 풀어보자
			nodes[pi].adj.add(new int[] { qi, ri });
			nodes[qi].adj.add(new int[] { pi, ri });
		}
		for (int i = 0; i < Q; i++) {
			// Q개의 질문에 따라 답을 sb에 저장
			// DFS 시행
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken()) - 1;
			visited = new boolean[N];
			visited[start] = true;
			cnt = 0;
			DFS(start, Integer.MAX_VALUE);
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void DFS(int current, int min) {
		for (int[] arr : nodes[current].adj) {
			int curMin = min;
			int idx = arr[0]; // 목적지
			int usa = arr[1]; // 가중치
			// 미방문인 노드에 대해 거리 계산하고 재귀
			if (!visited[idx]) {
				curMin = usa < curMin ? usa : curMin;
				visited[idx] = true;
				if (curMin >= K)
					cnt++;
				DFS(idx, curMin);
				visited[idx] = false;
			}
		}
	}
}