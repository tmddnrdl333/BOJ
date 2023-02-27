package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 323,360kb
// 932ms

public class Main_11723_집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int S = 0;

	public static void main(String[] args) throws IOException {
		int M = Integer.parseInt(br.readLine());
		for (; M > 0; M--) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			exec(command);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void exec(String command) {
		char c1 = command.charAt(0);
		char c2 = command.charAt(1);
		if (c1 == 'a' && c2 == 'l') {
			// all
			S = (1 << 20) - 1;
		} else if (c1 == 'e') {
			// empty
			S = 0;
		} else {
			int num = Integer.parseInt(st.nextToken());
			switch (c1) {
			case 'a':
				// add
				S |= 1 << (num - 1);
				break;
			case 'c':
				// check
				if ((S & 1 << (num - 1)) != 0)
					sb.append(1);
				else
					sb.append(0);
				sb.append("\n");
				break;
			case 'r':
				// remove
				S &= ~(1 << (num - 1));
				break;
			case 't':
				// toggle
				S ^= 1 << (num - 1);
				break;
			}
		}
	}
}