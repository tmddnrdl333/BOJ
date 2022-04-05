package ps_BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 16,388kb
// 248ms

public class Main_2531_회전초밥 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N, d, k, c;
	static int[] arr;
	static int[] count;
	static int res = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		count = new int[d + 1];
		count[c]++;
		for (int i = 0; i < k; i++) {
			count[arr[i]]++;
		}

		for (int i = 0; i < N; i++) {
			count();
			count[arr[i]]--;
			count[arr[(i + k) % N]]++;
		}
		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();
	}

	public static void count() {
		int cnt = 0;
		for (int i = 1; i <= d; i++) {
			if (count[i] > 0) {
				cnt++;
			}
		}
		res = cnt > res ? cnt : res;
	}
}
