package boj0220;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static StringBuilder sb = new StringBuilder();

	static int k;
	static int[] input, output;

	// 11,964kb
	// 88ms

	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;
			input = new int[k];
			for (int i = 0; i < k; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			output = new int[6];
			combi(0, 0);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void combi(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++)
				sb.append(output[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = start; i < k; i++) {
			output[cnt] = input[i];
			combi(cnt + 1, i + 1);
		}
	}
}
