package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 433,632kb
// 856ms

public class Main_12852_1로_만들기_2 {
	static class num {
		int cnt;
		List<Integer> list;

		num(int cnt, List<Integer> list, int n) {
			this.cnt = cnt;
			this.list = new ArrayList<>();
			this.list.addAll(list);
			this.list.add(n);
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		num[] dp = new num[N + 1];
		dp[0] = new num(0, new ArrayList<>(), 0);
		dp[1] = new num(0, new ArrayList<>(), 1);
		for (int i = 2; i <= N; i++) {
			int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
			if (i % 3 == 0)
				a = dp[i / 3].cnt + 1;
			if (i % 2 == 0)
				b = dp[i / 2].cnt + 1;
			c = dp[i - 1].cnt + 1;
			if (a <= b && a <= c)
				dp[i] = new num(a, dp[i / 3].list, i);
			else if (b <= a && b <= c)
				dp[i] = new num(b, dp[i / 2].list, i);
			else if (c <= a && c <= b)
				dp[i] = new num(c, dp[i - 1].list, i);
		}
		int size = dp[N].list.size();
		for (int i = size - 1; i >= 0; i--)
			sb.append(dp[N].list.get(i) + " ");
		bw.write(dp[N].cnt + "\n" + sb.toString());
		bw.flush();
		bw.close();

	}
}