package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 85,176kb
// 404ms

public class Main_1914_하노이_탑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		bw.write(cnthanoi(N) + "\n");
		if (N <= 20)
			hanoi(N, 1, 3);
		bw.flush();
		bw.close();

	}

	public static BigInteger cnthanoi(int lv) {
		BigInteger bignum = new BigInteger("2");

		return bignum.pow(lv).subtract(new BigInteger("1"));
	}

	public static void hanoi(int lv, int from, int to) throws IOException {
		if (lv == 1) {
			bw.write(from + " " + to + "\n");
			return;
		}
		int temp = 6 - from - to;
		hanoi(lv - 1, from, temp);
		bw.write(from + " " + to + "\n");
		hanoi(lv - 1, temp, to);
	}
}