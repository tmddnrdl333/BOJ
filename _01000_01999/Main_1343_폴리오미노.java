package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,560kb
// 80ms

public class Main_1343_폴리오미노 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		char[] board = br.readLine().toCharArray();
		int len = board.length;
		int p = 0;
		boolean fail = false;
		while (p < len) {
			if (board[p] == 'X') {
				// 01. p자리에 X라면?
				if (p >= len - 1 || board[p + 1] == '.') {
					// 다음 자리가 존재하지 않는다면 FAIL
					fail = true;
					break;
				}
				if (board[p + 1] == 'X') {
					// 02. p 다음 자리가 X라면?
					if (p >= len - 2 || board[p + 2] == '.') {
						// 다음 다음 자리가 존재하지 않거나, '.'이라면 BB로 확정
						sb.append("BB");
						p += 2;
					} else {
						// 다음 다음 자리가 존재하며, X이다.
						// 03. p 다음 다음 다음 자리가 X여야 한다.
						if (p >= len - 3) {
							// 다음 다음 다음 자리가 존재하지 않는다면 FAIL
							fail = true;
							break;
						}
						// 다음 다음 다음 자리가 존재한다.
						if (board[p + 3] == 'X') {
							// 04. p 다음 다음 다음 자리가 X라면 AAAA로 확정
							sb.append("AAAA");
							p += 4;
						} else {
							// '.'이라면 FAIL
							fail = true;
							break;
						}
					}
				}
			} else {
				sb.append('.');
				p++;
			}
		}

		if (fail) {
			bw.write("-1");
		} else {
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
}