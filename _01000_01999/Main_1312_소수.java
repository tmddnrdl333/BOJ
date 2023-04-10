package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,780kb
// 92ms

public class Main_1312_소수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int res = A % B;
		for (int i = 0; i < N - 1; i++) {
			res *= 10;
			res %= B;
		}
		bw.write(res * 10 / B + "");
		bw.flush();
		bw.close();
	}
}