package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,600kb
// 76ms

public class Main_10824_네_수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String AB = st.nextToken() + st.nextToken();
		String CD = st.nextToken() + st.nextToken();

		bw.write(Long.parseLong(AB) + Long.parseLong(CD) + "");
		bw.flush();
		bw.close();
	}
}
