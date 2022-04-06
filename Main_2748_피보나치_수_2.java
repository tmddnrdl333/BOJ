package ps_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,636kb
// 76ms

public class Main_2748_피보나치_수_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n + 1];
		arr[1] = 1;
		for (int i = 2; i <= n; i++)
			arr[i] = arr[i - 1] + arr[i - 2];
		bw.write(Long.toString(arr[n]));
		bw.flush();
		bw.close();
	}
}