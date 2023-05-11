package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,560kb
// 76ms

public class Main_1283_단축키_지정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		boolean[] alphabet = new boolean[26];
		for (int n = 0; n < N; n++) {
			char[] input = br.readLine().toCharArray();
			int len = input.length;
			int target = -1;

			// 01. check first letters
			for (int i = 0; i < len; i++) {
				if (i == 0 || input[i - 1] == ' ') {
					if (Character.isLowerCase(input[i])) {
						if (!alphabet[input[i] - 'a']) {
							alphabet[input[i] - 'a'] = true;
							target = i;
							break;
						}
					} else {
						if (!alphabet[input[i] - 'A']) {
							alphabet[input[i] - 'A'] = true;
							target = i;
							break;
						}
					}
				} else {
					continue;
				}
			}

			// 02. check all letters
			if (target == -1) {
				for (int i = 0; i < len; i++) {
					if (!Character.isAlphabetic(input[i]))
						continue;
					if (Character.isLowerCase(input[i])) {
						if (!alphabet[input[i] - 'a']) {
							alphabet[input[i] - 'a'] = true;
							target = i;
							break;
						}
					} else {
						if (!alphabet[input[i] - 'A']) {
							alphabet[input[i] - 'A'] = true;
							target = i;
							break;
						}
					}
				}
			}

			if (target != -1) {
				for (int i = 0; i < len; i++) {
					if (i == target)
						sb.append("[").append(input[i]).append("]");
					else
						sb.append(input[i]);
				}
			} else {
				for (char c : input)
					sb.append(c);
			}
			sb.append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}