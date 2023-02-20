package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 21,124kb
// 148ms

public class Main_17413_단어_뒤집기_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Character> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		char[] inp = br.readLine().toCharArray();
		int len = inp.length;
		for (int i = 0; i < len; i++) {
			if (inp[i] == '<') {
				sb.append("<");
				i++;
				while (inp[i] != '>') {
					sb.append(inp[i++]);
				}
				sb.append(">");
				continue;
			}

			if (inp[i] != ' ') {
				while (i < len && inp[i] != ' ' && inp[i] != '<') {
					list.add(inp[i++]);
				}
				int size = list.size();
				for (int j = size - 1; j >= 0; j--) {
					sb.append(Character.toString(list.get(j)));
				}
				list.clear();
				i--;
				continue;
			}
			sb.append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}