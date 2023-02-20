package ps.BOJ._20000_29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 18,480kb
// 360ms

public class Main_24053_알고리즘_수업_삽입_정렬_3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static long[] A, B;
	static int cnt;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new long[N];
		B = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			B[i] = Long.parseLong(st.nextToken());

		for (int i = 0; i < N; i++)
			cnt += A[i] != B[i] ? 1 : 0;

		bw.write(insertionSort() ? "1" : "0");
		bw.flush();
		bw.close();
	}

	static boolean insertionSort() {
		if (cnt == 0)
			return true;
		for (int i = 1; i < N; i++) {
			int loc = i - 1;
			long newItem = A[i];
			while (0 <= loc && newItem < A[loc]) {
				cnt += A[loc + 1] == B[loc + 1] ? 1 : 0;
				A[loc + 1] = A[loc];
				cnt -= A[loc + 1] == B[loc + 1] ? 1 : 0;
				loc--;
				if (cnt == 0)
					return true;
			}
			if (loc + 1 != i) {
				cnt += A[loc + 1] == B[loc + 1] ? 1 : 0;
				A[loc + 1] = newItem;
				cnt -= A[loc + 1] == B[loc + 1] ? 1 : 0;
				if (cnt == 0)
					return true;
			}
		}
		return false;
	}
}