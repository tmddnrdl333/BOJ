package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 16,496kb
// 148ms

public class Main_9009_피보나치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		int[] fibo = new int[45];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i < 45; i++)
			fibo[i] = fibo[i - 2] + fibo[i - 1];

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			Stack<Integer> stack = new Stack<>();
			int num = Integer.parseInt(br.readLine());
			for (int j = 44; j > 0 && num != 0; j--) {
				if (fibo[j] <= num) {
					num -= fibo[j];
					stack.add(fibo[j]);
				}
			}
			while (!stack.isEmpty()) {
				sb.append(stack.pop() + " ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}