package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 77,420kb
// 348ms

public class Main_15565_귀여운_라이언 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int l = 0, r = 1;
		int cnt = arr[l] == 1 ? 1 : 0;
		int min = Integer.MAX_VALUE;

		try {
			while (true) {
				if (cnt < K) {
					cnt += arr[r++] == 1 ? 1 : 0;
				} else if (cnt > K) {
					cnt -= arr[l++] == 1 ? 1 : 0;
				} else {
					min = r - l < min ? r - l : min;
					cnt -= arr[l++] == 1 ? 1 : 0;
				}
			}
		} catch (Exception e) {
		}

		min = min == Integer.MAX_VALUE ? -1 : min;

		bw.write(min + "");
		bw.flush();
		bw.close();

	}
}