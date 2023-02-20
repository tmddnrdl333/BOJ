package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 48,856kb
// 384ms

public class Main_12841_정보대_등산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		long[] cross = new long[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			cross[i] = Long.parseLong(st.nextToken());

		long[] left = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n; i++)
			left[i] = Long.parseLong(st.nextToken());

		long[] right = new long[n];
		long rightSum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n; i++) {
			right[i] = Long.parseLong(st.nextToken());
			rightSum += right[i];
		}

		long min = cross[1] + rightSum;
		long tmp = min;
		int idx = 1;
		for (int i = 1; i < n; i++) {
			tmp = tmp - cross[i] + cross[i + 1] + left[i] - right[i];
			if (tmp < min) {
				idx = i + 1;
				min = tmp;
			}
		}

		bw.write(idx + " " + min);
		bw.flush();
		bw.close();
	}
}