package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 15,220kb
// 120ms

public class Main_10610_30 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		char[] input = br.readLine().toCharArray();
		int len = input.length;
		int res = 0;
		boolean zero = false;
		for (int i = 0; i < len; i++) {
			res = (res + input[i] - '0') % 3;
			if (!zero && input[i] == '0')
				zero = true;
		}
		if (res == 0 && zero) {
			// 내림차순
			Arrays.sort(input);
			String str = new String(input);
			bw.write(new StringBuilder(str).reverse().toString());
		} else {
			// -1
			bw.write("-1");
		}
		bw.flush();
		bw.close();
	}
}