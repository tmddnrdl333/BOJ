package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,460kb
// 76ms

public class Main_2992_크면서_작은_수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int[] arr;

	public static void main(String[] args) throws IOException {
		char[] str = br.readLine().toCharArray();
		int len = str.length;
		arr = new int[len];
		for (int i = 0; i < len; i++)
			arr[i] = str[i] - '0';

		int i = len - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;

		if (i == 0) {
			sb.append("0");
		} else {

			int j = len - 1;
			while (arr[i - 1] >= arr[j])
				--j;

			swap(i - 1, j);

			int k = len - 1;
			while (i < k)
				swap(i++, k--);

			for (int num : arr)
				sb.append(num);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}