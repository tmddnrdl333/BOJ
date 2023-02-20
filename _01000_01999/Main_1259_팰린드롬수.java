package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11384kb
// 72ms

public class Main_1259_팰린드롬수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		while (true) {
			String str = br.readLine();
			if (str.equals("0"))
				break;
			char[] arr = str.toCharArray();
			int len = arr.length;
			int s = 0, e = len - 1;
			boolean flag = true;
			while (s < e) {
				if (arr[s++] == arr[e--])
					continue;
				else {
					flag = false;
					break;
				}
			}
			if (flag)
				sb.append("yes\n");
			else
				sb.append("no\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}