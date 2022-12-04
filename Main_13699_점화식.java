package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 14304kb
// 128ms

public class Main_13699_점화식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		long[] res = new long[n + 1];
		res[0] = 1;
		for (int i = 1; i <= n; i++) {
			long val = 0;
			for (int j = 0; j < i; j++) {
				val += (long) res[j] * res[i - j - 1];
			}
			res[i] = val;
		}
		bw.write(res[n] + "");
		bw.flush();
		bw.close();
	}
}
