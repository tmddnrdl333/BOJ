package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 15,896kb
// 164ms

public class Main_11403_경로_찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] aM = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				aM[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (aM[i][k] + aM[k][j] == 2)
						aM[i][j] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(aM[i][j] + " ");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}