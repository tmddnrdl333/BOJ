package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 23,432kb
// 100ms

public class Main_2749_피보나치_수_3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		final int K = 1000000;
		final int P = 1500000;
		long n = Long.parseLong(br.readLine());

		n %= P;

		long[] arr = new long[(int) n + 1];

		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++)
			arr[i] = (arr[i - 1] + arr[i - 2]) % K;

		System.out.println(arr[(int) n]);
	}
}