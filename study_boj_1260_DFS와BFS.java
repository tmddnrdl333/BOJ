package study.day0214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 19,780kb
// 240ms

public class study_boj_1260_DFS와BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static StringBuilder sb = new StringBuilder();

	static boolean[][] map; // 인접 행렬
	static int N, M, V;

	static boolean[] dfsFlag;
	static boolean[] bfsFlag;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken()) - 1;

		map = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = true;
			map[b][a] = true;
		}

		// DFS (재귀)
		dfsFlag = new boolean[N];
		DFS(V);
		sb.append("\n");

		// BFS (Queue)
		bfsFlag = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		int idx = V; // 현재 인덱스

		q.add(idx);
		bfsFlag[idx] = true;

		while (!q.isEmpty()) {
			for (int i = 0; i < N; i++) {
				idx = q.peek();
				if (map[idx][i] && !bfsFlag[i]) {
					bfsFlag[i] = true;
					q.add(i);
				}
			}
			sb.append(q.poll() + 1).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static void DFS(int root) {
		dfsFlag[root] = true;
		sb.append(root + 1).append(" ");
		for (int i = 0; i < N; i++) {
			if (map[root][i] && !dfsFlag[i]) {
				DFS(i);
			}
		}
	}
}
