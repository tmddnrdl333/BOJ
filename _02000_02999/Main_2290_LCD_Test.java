package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,636kb
// 80ms

public class Main_2290_LCD_Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int s;

	static int[][] arr = { { 1, 1, 1, 0, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0 }, { 1, 0, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1 }, { 0, 1, 1, 1, 0, 1, 0 }, { 1, 1, 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1 } };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		char[] n = st.nextToken().toCharArray();

		for (int i = 0; i < 7; i++) {
			if (i % 3 == 0) {
				for (char c : n)
					hori(c, i);
				sb.append("\n");
			} else if (i % 3 == 1) {
				for (int j = 0; j < s; j++) {
					for (char c : n)
						vert(c, i);
					sb.append("\n");
				}
			} else {
				continue;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void hori(char c, int part) {
		sb.append(" ");
		for (int i = 0; i < s; i++)
			sb.append(arr[c - '0'][part] == 1 ? "-" : " ");
		sb.append("  ");
	}

	static void vert(char c, int part) {
		sb.append(arr[c - '0'][part] == 1 ? "|" : " ");
		for (int i = 0; i < s; i++)
			sb.append(" ");
		sb.append(arr[c - '0'][part + 1] == 1 ? "|" : " ").append(" ");
	}
}