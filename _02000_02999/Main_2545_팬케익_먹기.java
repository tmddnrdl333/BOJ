package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12,000kb
// 88ms

public class Main_2545_팬케익_먹기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			long[] arr = new long[3];
			arr[0] = Long.parseLong(st.nextToken());
			arr[1] = Long.parseLong(st.nextToken());
			arr[2] = Long.parseLong(st.nextToken());
			long D = Long.parseLong(st.nextToken());

			Arrays.sort(arr);

			long sum = arr[0] + arr[1] + arr[2] - D;
			long tmp = Math.min(sum / 3, arr[0]);
			long a = tmp;
			sum -= tmp;
			tmp = Math.min(sum / 2, arr[1]);
			sb.append(a * tmp * (sum - tmp)).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}