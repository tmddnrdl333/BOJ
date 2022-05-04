package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,548kb
// 80ms

public class Main_4153_직각삼각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c == 0)
				break;
			int max = Math.max(a, Math.max(b, c));
			int min = Math.min(a, Math.min(b, c));
			int mid = a + b + c - max - min;
			if (max * max - min * min - mid * mid == 0)
				sb.append("right\n");
			else
				sb.append("wrong\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}