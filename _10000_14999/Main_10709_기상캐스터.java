package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12,056kb
// 92ms

public class Main_10709_기상캐스터 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < W; j++)
				map[i][j] = tmp[j] == '.' ? 0 : 1;
		}

		int[][] res = new int[H][W];
		for (int i = 0; i < H; i++)
			Arrays.fill(res[i], -1);

		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if (map[i][j] == 1)
					res[i][j] = 0;
				else if (map[i][j] == 0)
					if (j > 0 && res[i][j - 1] > -1)
						res[i][j] = res[i][j - 1] + 1;
					else
						continue;
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(res[i][j]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}