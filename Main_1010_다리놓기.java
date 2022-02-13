package boj0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 13072kb
// 104ms

public class Main_1010_다리놓기 {
	static int N, M;
	static BigInteger res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			res = new BigInteger("1");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			calc(M, N);
			sb.append(res + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void calc(int M, int N) {
		int[] m = new int[M + 1];
		for (int i = M - N + 1; i <= M; i++) {
			m[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			m[i] = m[i] - i;
		}
		for (int i = 1; i <= N; i++) {
			if (m[i] == 0)
				break;
			res = res.multiply(BigInteger.valueOf(m[M + 1 - i])).divide(BigInteger.valueOf(-m[i]));
		}
	}
}
