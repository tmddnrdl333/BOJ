package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,604kb
// 80ms

public class Main_1629_곱셈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int C;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		bw.write(Long.toString(pow(A, B)));
		bw.flush();
		bw.close();

	}

	public static long pow(long A, long exp) {
		if (exp == 1)
			return A % C;
		long temp = pow(A, exp / 2);
		if (exp % 2 == 0)
			return temp * temp % C;
		else
			return (temp * temp % C) * A % C;
	}
}