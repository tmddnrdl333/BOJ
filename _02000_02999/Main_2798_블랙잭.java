package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 13,144kb
// 144ms

public class Main_2798_블랙잭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[] comb;
	static int res;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		comb = new int[N];
		comb[N - 1] = 1;
		comb[N - 2] = 1;
		comb[N - 3] = 1;
		do {
			int sum = 0;
			for (int i = 0; i < N; i++)
				if (comb[i] == 1)
					sum += arr[i];
			if (sum < M)
				res = sum > res ? sum : res;
			else if (sum == M) {
				res = M;
				break;
			}
		} while (np());
		System.out.println(res);
	}

	public static boolean np() {
		int i = N - 1;
		while (i > 0 && comb[i - 1] >= comb[i])
			--i;
		if (i == 0)
			return false;
		int j = N - 1;
		while (comb[i - 1] >= comb[j])
			--j;
		swap(i - 1, j);
		int k = N - 1;
		while (i < k)
			swap(i++, k--);
		return true;
	}

	public static void swap(int i, int j) {
		int temp = comb[i];
		comb[i] = comb[j];
		comb[j] = temp;
	}
}