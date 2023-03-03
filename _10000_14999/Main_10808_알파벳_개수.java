package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,576kb
// 80ms

public class Main_10808_알파벳_개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		char[] arr = br.readLine().toCharArray();
		int[] res = new int[26];
		for (char c : arr) {
			res[c - 'a']++;
		}
		for (int i = 0; i < 26; i++)
			sb.append(res[i]).append(" ");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
