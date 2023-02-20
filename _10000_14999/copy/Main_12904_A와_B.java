package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,584kb
// 76ms

public class Main_12904_A와_B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		char[] S = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();
		int sLen = S.length, tLen = T.length;
		int opCnt = tLen - sLen; // 연산해야 할 횟수
		int sp = tLen - 1, ep = 0; // sp : 끝에 있는 문자의 인덱스, ep : 시작에 있어야 할 문자의 인덱스
		for (int i = 0; i < opCnt; i++) {
			int cur = T[sp] - 'A';
			if (sp > ep) {
				sp--;
			} else {
				sp++;
			}
			if (cur == 1) {
				int temp = sp;
				sp = ep;
				ep = temp;
			}
		}
		int res = 1;
		if (ep <= sp) {
			for (int i = 0; i < sLen; i++)
				if (S[i] != T[ep++]) {
					res = 0;
					break;
				}
		} else {
			for (int i = 0; i < sLen; i++)
				if (S[i] != T[ep--]) {
					res = 0;
					break;
				}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}
