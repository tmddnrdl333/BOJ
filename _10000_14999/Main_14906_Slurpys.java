package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

// 11,592kb
// 76ms

public class Main_14906_Slurpys {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		outer: for (int t = 0; t < T; t++) {
			String str = br.readLine();
			int len = str.length();
			if (len < 2) {
				sb.append("NO\n");
				continue;
			}
			for (int i = 2; i <= len; i++) {
				if (slimp(str.substring(0, i))) {
					if (slump(str.substring(i, len))) {
						sb.append("YES\n");
						continue outer;
					}
				}
				if (i == len) {
					sb.append("NO\n");
					continue outer;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static boolean slimp(String str) {
		int len = str.length();
		if (len <= 2) {
			if (str.equals("AH"))
				return true;
			else
				return false;
		}
		if (str.charAt(0) == 'A') {
			if (str.charAt(1) == 'B') {
				if (str.charAt(len - 1) == 'C')
					return slimp(str.substring(2, len - 1));
			} else {
				if (str.charAt(len - 1) == 'C')
					return slump(str.substring(1, len - 1));
			}
		}

		return false;
	}

	static String slump = "((D|E)F+)+G";

	public static boolean slump(String str) {
		if (Pattern.matches(slump, str))
			return true;
		return false;
	}
}