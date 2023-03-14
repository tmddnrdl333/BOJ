package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 168,008kb
// 456ms

public class Main_10986_나머지_합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long res = 0;
		long[] s = new long[N + 1];
		long[] cnt = new long[M];
		for (int i = 1; i <= N; i++) {
			s[i] = (s[i - 1] + Integer.parseInt(st.nextToken())) % M;
			if (s[i] == 0)
				res++;
			cnt[(int) s[i]]++;
		}
		for (int i = 0; i < M; i++) {
			if (cnt[i] > 1)
				res += (cnt[i] * (cnt[i] - 1) / 2);
		}
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}