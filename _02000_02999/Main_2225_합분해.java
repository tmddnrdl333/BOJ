package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,968kb
// 80ms

public class Main_2225_합분해 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static final int MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// N+1 칸막이는 K-1개
		// N+1 H K-1 = N+1 + K-1 - 1 C N+1 - 1
		// N+K-1 C N
		// N+K-1 에서 N 개 / N 부터 1 까지

		int[][] nCk = new int[N + K][N + 1];

		for (int i = 1; i <= N + K - 1; i++) {
			for (int j = 0; j <= i && j <= N; j++) {
				if (i == j || i == 1 || j == 0)
					nCk[i][j] = 1;
				else
					nCk[i][j] = (nCk[i - 1][j - 1] + nCk[i - 1][j]) % MOD;
//                System.out.println(i + ".C." + j + " " + nCk[i][j]);
			}
		}

		bw.write(nCk[N + K - 1][N] + "");
		bw.flush();
		bw.close();

	}
}
