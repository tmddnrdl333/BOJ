package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 11,936kb
// 84ms

public class Main_1935_후위_표기식_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		char[] command = br.readLine().toCharArray();
		Stack<Double> stack = new Stack<>();
		double[] nums = new double[N];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());

		for (char c : command) {
			if (c >= 'A' && c <= 'Z') {
				stack.add(nums[c - 'A']);
			} else {
				double n2 = stack.pop();
				double n1 = stack.pop();
				double n3 = 0;
				switch (c) {
				case '+':
					n3 = n1 + n2;
					break;
				case '-':
					n3 = n1 - n2;
					break;
				case '*':
					n3 = n1 * n2;
					break;
				case '/':
					n3 = n1 / n2;
					break;
				}
				stack.add(n3);
			}
		}
		bw.write(String.format("%.2f", stack.pop()));
		bw.flush();
		bw.close();
	}
}