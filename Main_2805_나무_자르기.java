package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 172,364kb
// 516ms

public class Main_2805_나무_자르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		long s = 0, e = 0;
		for (int i = 0; i < N; i++) {
			long cur = Long.parseLong(st.nextToken());
			arr[i] = cur;
			e = cur > e ? cur : e;
		}
		long m = 0, ans = 0;
		while (s <= e) {
			long sum = 0;
			m = (s + e) / 2;
			for (int i = 0; i < N; i++) {
				sum += (arr[i] - m > 0 ? arr[i] - m : 0);
			}
			if (sum >= M) {
				s = m + 1;
			} else {
				ans = m;
				e = m - 1;
			}
		}
		bw.write(Long.toString(e));
		bw.flush();
		bw.close();
	}
}