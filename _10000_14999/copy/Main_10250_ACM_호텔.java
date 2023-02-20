package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,860kb
// 80ms

public class Main_10250_ACM_호텔 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			@SuppressWarnings("unused")
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int num = (N - 1) / H + 1;
			int floor = (N - 1) % H + 1;
			sb.append(floor).append(num < 10 ? "0" : "").append(num).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}