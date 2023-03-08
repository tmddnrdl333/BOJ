package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 20,960kb
// 176ms

public class Main_10974_모든_순열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;
		do {
			for (int i = 0; i < N; i++)
				sb.append(arr[i]).append(" ");
			sb.append("\n");
		} while (np());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean np() {
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			i--;
		if (i == 0)
			return false;
		int j = N - 1;
		while (arr[i - 1] >= arr[j])
			j--;
		swap(i - 1, j);
		int k = N - 1;
		while (i < k)
			swap(i++, k--);
		return true;
	}

	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}