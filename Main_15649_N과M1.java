package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 53,020kb
// 228ms

public class Main_15649_N과M1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] output;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		output = new int[M];
		visited = new boolean[N];
		permu(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void permu(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				sb.append(output[i] + " ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				output[cnt] = i + 1;
				visited[i] = true;
				permu(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
