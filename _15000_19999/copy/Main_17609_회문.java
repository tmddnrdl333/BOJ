package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 41888kb
// 228ms

public class Main_17609_회문 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int T;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			arr = br.readLine().toCharArray();
			sb.append(Math.min(checkL(), checkR())).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int checkL() {
		int L = arr.length;
		int half = (L + 1) / 2;

		boolean del = false;
		for (int s = 0, e = L - 1; s < half; s++, e--) {
			if (arr[s] != arr[e]) {
				if (del)
					return 2;
				else {
					if (arr[s + 1] == arr[e]) {
						s++;
					} else if (arr[s] == arr[e - 1]) {
						e--;
					} else
						return 2;
					del = true;
				}
			}
		}
		if (del)
			return 1;
		else
			return 0;
	}

	public static int checkR() {
		int L = arr.length;
		int half = (L + 1) / 2;

		boolean del = false;
		for (int s = 0, e = L - 1; s < half; s++, e--) {
			if (arr[s] != arr[e]) {
				if (del)
					return 2;
				else {
					if (arr[s] == arr[e - 1]) {
						e--;
					} else if (arr[s + 1] == arr[e]) {
						s++;
					} else
						return 2;
					del = true;
				}
			}
		}
		if (del)
			return 1;
		else
			return 0;
	}
}