package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

// 13,296kb
// 96ms

public class Main_9996_한국이_그리울_땐_서버에_접속하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		String expected = br.readLine().replaceAll("\\*", ".*");
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (Pattern.matches(expected, input))
				sb.append("DA\n");
			else
				sb.append("NE\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}