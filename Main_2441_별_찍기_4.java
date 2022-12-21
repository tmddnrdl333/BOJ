package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,688kb
// 84ms

public class Main_2441_별_찍기_4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = N - i; j < N; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < N - i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}