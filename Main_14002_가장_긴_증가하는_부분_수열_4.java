package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 13,012kb
// 104ms

public class Main_14002_가장_긴_증가하는_부분_수열_4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		int res = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = dp[j] + 1 > dp[i] ? dp[j] + 1 : dp[i];
					res = dp[i] > res ? dp[i] : res;
				}
			}
		}

//		System.out.println(Arrays.toString(dp));

		sb.append(res).append("\n");
		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (dp[i] == res) {
				stack.add(arr[i]);
				res--;
			}
		}
		while (!stack.isEmpty())
			sb.append(stack.pop()).append(" ");
		sb.setLength(sb.length() - 1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
