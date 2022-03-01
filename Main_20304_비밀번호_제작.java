package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 72,508kb
// 436ms

public class Main_20304_비밀번호_제작 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static Queue<Integer> q = new LinkedList<>();
	static int[] arr;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		Arrays.fill(arr, Integer.MIN_VALUE);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[temp] = 0;
			q.add(temp);
		}
		int ans = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < 20; i++) {
				int xor = cur ^ (1 << i);
				if (xor > N || arr[xor] != Integer.MIN_VALUE)
					continue;
				arr[xor] = arr[cur] + 1;
				q.add(xor);
				ans = arr[xor] > ans ? arr[xor] : ans;
			}
		}

		bw.write(Integer.toString(ans));
		bw.flush();
		bw.close();
	}

}