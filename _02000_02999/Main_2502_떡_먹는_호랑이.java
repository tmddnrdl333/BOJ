package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,448kb
// 920ms

public class Main_2502_떡_먹는_호랑이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] a = new int[D + 1];
		int[] b = new int[D + 1];
		a[1] = 1;
		b[2] = 1;
		for (int i = 3; i <= D; i++) {
			a[i] = a[i - 2] + a[i - 1];
			b[i] = b[i - 2] + b[i - 1];
		}

		int A = 0, B = 0;
		outer: for (B = 1; B < K; B++)
			for (A = 1; A <= B; A++)
				if (a[D] * A + b[D] * B == K)
					break outer;

		bw.write(A + "\n" + B);
		bw.flush();
		bw.close();

	}
}