package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,556kb
// 76ms

public class Main_9625_BABBA {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int dpa[] = new int[N + 1];
		int dpb[] = new int[N + 1];
		dpa[1] = 0;
		dpb[1] = 1;
		for (int i = 2; i <= N; i++) {
			dpa[i] = dpb[i - 1];
			dpb[i] = dpb[i - 1] + dpa[i - 1];
		}
		bw.write(dpa[N] + " " + dpb[N]);
		bw.flush();
		bw.close();
	}
}