package study.day0705;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 28,364kb
// 296ms

public class Main_2110_공유기_설치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, C;
	static int[] arr;

	static int max = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		C = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = arr[i] > max ? arr[i] : max;
		}
		Arrays.sort(arr);
		int s = 0, e = max;
		int ans = 0;
		while (s <= e) {
			int m = (s + e) / 2;
			if (isPossible(m)) {
				ans = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		bw.write(Integer.toString(ans));
		bw.flush();
		bw.close();

	}

	public static boolean isPossible(int m) {
		int prev = arr[0], cnt = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] - prev >= m) {
				prev = arr[i];
				if (++cnt == C)
					return true;
			}
		}
		return false;
	}
}