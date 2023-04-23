package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 13,004kb
// 128ms

public class Main_1969_DNA {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();

		char[] res = new char[M];
		for (int j = 0; j < M; j++) {
			int a = 0, c = 0, g = 0, t = 0;
			for (int i = 0; i < N; i++) {
				char dna = arr[i][j];
				switch (dna) {
				case 'A':
					a++;
					break;
				case 'C':
					c++;
					break;
				case 'G':
					g++;
					break;
				case 'T':
					t++;
					break;
				}
			}
			int max = Math.max(a, Math.max(c, Math.max(g, t)));
			if (max == a)
				res[j] = 'A';
			else if (max == c)
				res[j] = 'C';
			else if (max == g)
				res[j] = 'G';
			else
				res[j] = 'T';
		}

		int pnt = 0;
		for (int j = 0; j < M; j++) {
			sb.append(res[j]);
			for (int i = 0; i < N; i++)
				if (arr[i][j] != res[j])
					pnt++;
		}

		sb.append("\n" + pnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}