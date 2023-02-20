package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 31,988kb
// 292ms

public class Main_2470_두_용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int s = 0, e = N - 1;
		int sum = arr[s] + arr[e];
		int res = Integer.MAX_VALUE;
		int rs = s, re = e;
		while (s < e) {
//			System.out.println(arr[s] + " " + arr[e] + " " + sum);
			int cur = Math.abs(sum);
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
		System.out.println(arr[rs] + " " + arr[re]);
	}
}