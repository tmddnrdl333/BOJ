package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,472kb
// 76ms

public class Main_2775_부녀회장이_될테야 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine()); // k층 n호
			int[][] arr = new int[k + 1][n + 1];
			for (int i = 1; i <= n; i++)
				arr[0][i] = i;
			for (int i = 1; i <= k; i++) // 층
				for (int j1 = 1; j1 <= n; j1++) // 호
					for (int j2 = 1; j2 <= j1; j2++)
						arr[i][j1] += arr[i - 1][j2];
			sb.append(arr[k][n] + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}