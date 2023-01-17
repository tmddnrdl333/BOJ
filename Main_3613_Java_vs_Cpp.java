package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,648kb
// 80ms

public class Main_3613_Java_vs_Cpp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		char[] A = br.readLine().toCharArray();
		int len = A.length;

		int a = 0;

		try {
			// 예외처리
			boolean underbar = false;
			boolean isCpp = false;
			boolean isJava = false;

			if (A[0] == '_' || A[len - 1] == '_')
				throw new Exception();
			if (A[0] <= 'Z')
				throw new Exception();
			for (int i = 0; i < len; i++) {
				if (A[i] <= 'Z')
					isJava = true;
				if (A[i] == '_') {
					isCpp = true;
					if (underbar)
						throw new Exception();
					underbar = true;
				} else
					underbar = false;
			}
			if (isJava && isCpp)
				throw new Exception();

			// 변환 알고리즘
			while (true) {
				if (A[a] <= 'Z') {
					sb.append("_" + (char) (A[a] + 32));
				} else if (A[a] == '_') {
					a++;
					sb.append((char) (A[a] - 32));
				} else {
					sb.append(A[a]);
				}

				a++;
				if (a >= len)
					break;
			}

		} catch (Exception e) {
			sb = new StringBuilder();
			sb.append("Error!");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}