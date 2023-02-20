package ps.BOJ._03000_03999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 32048kb
// 372ms

public class Main_3747_교수가_된_현우 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int N = Integer.parseInt(br.readLine());
			int fives = 0;
			while (N != 0) {
				N /= 5;
				fives += N;
			}
			sb.append(fives + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
