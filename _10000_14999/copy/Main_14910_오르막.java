package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14910_오르막 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String args[]) throws IOException {
		st = new StringTokenizer(br.readLine());
		int before = Integer.parseInt(st.nextToken());
		String res = "Good";
		while (st.hasMoreTokens()) {
			int now = Integer.parseInt(st.nextToken());
			if (now < before) {
				res = "Bad";
				break;
			}
			before = now;
		}
		bw.write(res);
		bw.flush();
		bw.close();
	}
}