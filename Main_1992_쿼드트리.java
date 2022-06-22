package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,788kb
// 84ms

public class Main_1992_쿼드트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		make(0, 0, N);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void make(int r, int c, int length) {
		if (isOne(r, c, length)) {
			sb.append(map[r][c]);
		} else {
			sb.append("(");
			make(r, c, length / 2);
			make(r, c + length / 2, length / 2);
			make(r + length / 2, c, length / 2);
			make(r + length / 2, c + length / 2, length / 2);
			sb.append(")");
		}
	}

	public static boolean isOne(int r, int c, int length) {
		int one = map[r][c];
		for (int i = r; i < r + length; i++)
			for (int j = c; j < c + length; j++)
				if (map[i][j] != one)
					return false;
		return true;
	}
}