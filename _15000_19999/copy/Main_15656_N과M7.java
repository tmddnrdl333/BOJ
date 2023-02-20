package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 407,888kb
// 880ms

public class Main_15656_N과M7 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] input, output;

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
			output[cnt] = input[i];
			permu(cnt + 1);
		}
	}
}
