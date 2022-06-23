package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

// 15,308kb
// 140ms

public class Main_1013_Contact {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String pattern = "(100+1+|01)+";

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (; T != 0; T--) {
			if (Pattern.matches(pattern, br.readLine()))
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}