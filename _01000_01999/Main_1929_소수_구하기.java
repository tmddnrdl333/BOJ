package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 17,164kb
// 176ms

public class Main_1929_소수_구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int bSize = N / 8 + 1;
		byte[] prime = new byte[bSize];
		prime[0] = 3;
		int max = (int) Math.sqrt(N);
		for (int i = 2; i <= max; i++) {
			int cur = i + i;
			while (cur <= N) {
				prime[cur >>> 3] |= 1 << (cur & 7);
				cur += i;
			}
		}

		int start = M >>> 3, end = N >>> 3;
		for (int i = start; i <= end; i++) {
			for (int j = 0; j < 8; j++) {
				int cur = (i << 3) + j;
				if (cur >= M && cur <= N && (prime[i] & 1 << j) == 0)
					sb.append(cur).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}