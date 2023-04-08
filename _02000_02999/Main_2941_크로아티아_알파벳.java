package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,580kb
// 76ms

public class Main_2941_크로아티아_알파벳 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		char[] input = br.readLine().toCharArray();
		int len = input.length;
		int res = 0;
		for (int i = 0; i < len; i++) {
			// 01
			if (i < len - 1) {
				char next = input[i + 1];
				char next2 = i < len - 2 ? input[i + 2] : '?';
				switch (input[i]) {
				case 'c':
					if (next == '=' || next == '-')
						i++;
					break;
				case 'd':
					if (next == 'z' && next2 == '=')
						i += 2;
					else if (next == '-')
						i++;
					break;
				case 'l':
					if (next == 'j')
						i++;
					break;
				case 'n':
					if (next == 'j')
						i++;
					break;
				case 's':
					if (next == '=')
						i++;
					break;
				case 'z':
					if (next == '=')
						i++;
					break;
				}
				res++;
			}
			// 02
			else {
				res++;
			}

		}
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}