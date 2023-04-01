package ps.BOJ._20000_29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 27,516kb
// 232ms

public class Main_25192_인사성_밝은_곰곰이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		int cnt = 0;
		String input = br.readLine();

		for (; N > 0; N--) {
			if (input.equals("ENTER")) {
				cnt += set.size();
				set = new HashSet<>();
			} else {
				set.add(input);
			}
			if (N != 1)
				input = br.readLine();
		}

		cnt += set.size();

		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}