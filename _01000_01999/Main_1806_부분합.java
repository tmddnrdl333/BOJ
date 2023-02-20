package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 22,192kb
// 220ms

public class Main_1806_부분합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		int max = Integer.MAX_VALUE;
		int window = 0;
		int first = 0, size = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;

			while (window >= S) {
				window -= arr[first++];
				size--;
			}

			window += cur;
			size++;

			while (window - arr[first] >= S) {
				window -= arr[first++];
				size--;
			}

			if (window >= S)
				max = size < max ? size : max;
		}
		if (max == Integer.MAX_VALUE)
			max = 0;
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}