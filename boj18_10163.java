package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 19444kb
// 492ms

public class boj18_10163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];
		int[] Nth = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			for (int j = r; j < r + h; j++) {
				for (int k = c; k < c + w; k++) {
					if (map[j][k] != 0)
						Nth[map[j][k]]--;
					map[j][k] = i;
					Nth[i]++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(Nth[i] + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
