package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,580kb
// 76ms

public class Main_2562_최댓값 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int max = 0, idx = 0;
		for (int i = 0; i < 9; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a > max) {
				max = a;
				idx = i + 1;
			}
		}
		bw.write(max + "\n" + idx);
		bw.flush();
		bw.close();
	}
}