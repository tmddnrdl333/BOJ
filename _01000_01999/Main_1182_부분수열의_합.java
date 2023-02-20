package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 41,564kb
// 208ms

public class Main_1182_부분수열의_합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, S;
	static int[] arr;
	static int res = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		subset(1);
		System.out.println(res);
	}

	public static void subset(int flag) {
		if (flag == 1 << N)
			return;
		int sum = 0;
		for (int i = 0; i < N; i++)
			if ((flag & 1 << i) != 0)
				sum += arr[i];
		if (sum == S)
			res++;

		subset(flag + 1);
	}
}