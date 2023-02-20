package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11,684kb
// 80ms

public class Main_14501_퇴사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] T, P;

	static int max = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
			T[i] = t;
			P[i] = p;
		}
		dfs(1, 0);
		System.out.println(max);
	}

	public static void dfs(int date, int pay) {
		if (date == N + 1) {
			max = pay > max ? pay : max;
			return;
		}
		dfs(date + 1, pay);
		int nDate = date + T[date];
		if (nDate > N + 1)
			return;
		dfs(nDate, pay + P[date]);
	}
}