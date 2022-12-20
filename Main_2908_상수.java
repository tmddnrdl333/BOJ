package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,608kb
// 80ms

public class Main_2908_상수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();

		int aa = 100 * (a.charAt(2) - '0') + 10 * (a.charAt(1) - '0') + a.charAt(0) - '0';
		int bb = 100 * (b.charAt(2) - '0') + 10 * (b.charAt(1) - '0') + b.charAt(0) - '0';

		bw.write(Math.max(aa, bb) + "");
		bw.flush();
		bw.close();
	}
}