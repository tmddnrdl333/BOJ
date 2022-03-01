package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 312,504kb
// 560ms

public class Main_15651_N과M3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] output;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		output = new int[M];
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
			output[cnt] = i + 1;
			permu(cnt + 1);
		}
	}
}
