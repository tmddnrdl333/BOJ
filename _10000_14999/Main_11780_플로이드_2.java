package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 49,648kb
// 452ms

public class Main_11780_플로이드_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static final int INF = 10000001;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] aM = new int[n + 1][n + 1];
		int[][] path = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++) {
				path[i][j] = INF;
				if (i != j)
					aM[i][j] = INF;
			}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			aM[from][to] = Math.min(cost, aM[from][to]);
			path[from][to] = from;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= n; j++) {
					if (i == j || j == k)
						continue;
					if (aM[i][j] > aM[i][k] + aM[k][j]) {
						aM[i][j] = aM[i][k] + aM[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (aM[i][j] == INF)
					sb.append(0);
				else
					sb.append(aM[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (path[i][j] == INF)
					sb.append("0\n");
				else {
					Stack<Integer> stack = new Stack<>();
					int p = j;
					while (p != i) {
						stack.add(p);
						p = path[i][p];
					}
					stack.add(i);

					sb.append(stack.size()).append(" ");
					while (!stack.isEmpty())
						sb.append(stack.pop()).append(" ");
					sb.append("\n");

				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}