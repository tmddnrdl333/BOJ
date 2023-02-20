package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 14,352kb
// 184ms

public class Main_2473_세_용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static long[] arr;
	static final long INF = 3000000001l;
	static long max = INF;
	static long ans1, ans2, ans3;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());
		Arrays.sort(arr);

		for (int i = 0; i < N - 2; i++) {
			two_solution(i);
		}

		System.out.println(ans1 + " " + ans2 + " " + ans3);

	}

	public static void two_solution(int first) {
		int s = first + 1, e = N - 1;
		long sum = arr[first] + arr[s] + arr[e];
		long res = INF;
		int rs = s, re = e;
		while (s < e) {
			long cur = Math.abs(sum);
			if (cur < res) {
				res = cur;
				rs = s;
				re = e;
			}
			if (sum == 0)
				break;
			else if (sum > 0) {
				sum -= arr[e];
				e--;
				sum += arr[e];
			} else {
				sum -= arr[s];
				s++;
				sum += arr[s];
			}
		}
		if (max > res) {
			max = res;
			ans1 = arr[first];
			ans2 = arr[rs];
			ans3 = arr[re];
		}
	}
}