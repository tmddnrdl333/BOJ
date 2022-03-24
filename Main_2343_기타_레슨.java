package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 23268kb
// 264ms

public class Main_2343_기타_레슨 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = arr[i] > max ? arr[i] : max;
		}

		int start = max, end = (int) 1e9;
		int ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (getCnt(mid) > M) {
				start = mid + 1;
			} else {
				ans = mid;
				end = mid - 1;
			}
		}
		bw.write(Integer.toString(ans));
		bw.flush();
		bw.close();
	}

	public static int getCnt(int mid) {
		int remain = mid;
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (remain - arr[i] < 0) {
				remain = mid;
				cnt++;
			}
			remain -= arr[i];
		}
		return cnt;
	}
}