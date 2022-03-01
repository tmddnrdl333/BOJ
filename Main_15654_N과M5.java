package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 70,824kb
// 316ms

public class Main_15654_N과M5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] input, output;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
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
				output[cnt] = input[i];
				visited[i] = true;
				permu(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
