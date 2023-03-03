package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 11,636kb
// 76ms

public class Main_2089_m2진수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		if (N == 0)
			sb.append(0);
		Stack<Boolean> bit = new Stack<>();
		while (N != 0) {
			boolean isNeg = N < 0;
			int q = Math.floorDiv(N, 2);
			int r = Math.floorMod(N, 2);
			N = -q;
			bit.add(r == 1);
		}
		while (!bit.isEmpty())
			sb.append(bit.pop() ? 1 : 0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}