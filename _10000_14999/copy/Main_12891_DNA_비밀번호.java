package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 22,304kb
// 200ms

public class Main_12891_DNA_비밀번호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static char[] arr;
	static int A, C, G, T;
	static int a, c, g, t;
	static int cnt;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		arr = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < P; i++) {
			countACGT(i, 1);
		}

		check();

		for (int i = 0; i < S - P; i++) {
			countACGT(i, -1);
			countACGT(i + P, 1);
			check();
		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}

	static void countACGT(int i, int pm) {
		switch (arr[i]) {
		case 'A':
			a += pm;
			break;
		case 'C':
			c += pm;
			break;
		case 'G':
			g += pm;
			break;
		case 'T':
			t += pm;
			break;
		}
	}

	static void check() {
		if (a >= A && c >= C && g >= G && t >= T)
			cnt++;
	}
}