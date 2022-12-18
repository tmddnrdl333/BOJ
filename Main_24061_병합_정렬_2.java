package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 160,440kb
// 764ms	

public class Main_24061_병합_정렬_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static long[] A;
	static int cnt;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		merge_sort(1, N);
		bw.write("-1");
		bw.flush();
		bw.close();
	}

	static void merge_sort(int p, int r) throws IOException {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(p, q);
			merge_sort(q + 1, r);
			merge(p, q, r);
		}
	}

	static void merge(int p, int q, int r) throws IOException {
		long[] tmp = new long[r - p + 2]; //
		int i = p, j = q + 1, t = 1;
		while (i <= q && j <= r) {
			if (A[i] <= A[j])
				tmp[t++] = A[i++];
			else
				tmp[t++] = A[j++];
		}
		while (i <= q)
			tmp[t++] = A[i++];
		while (j <= r)
			tmp[t++] = A[j++];
		i = p;
		t = 1;
		while (i <= r) {
			cnt++;
			A[i++] = tmp[t++];
			if (cnt == K) {
				printArr();
				System.exit(0);
			}
		}
	}

	static void printArr() throws IOException {
		for (int i = 1; i <= N; i++)
			sb.append(A[i]).append(" ");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}