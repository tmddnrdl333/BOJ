package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11632kb
// 84ms

public class boj11_2669 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] arr = new int[4][4];
		int[][] map = new int[100][100];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
			for (int j = arr[i][0]; j < arr[i][2]; j++) {
				for (int k = arr[i][1]; k < arr[i][3]; k++) {
					map[j][k] = 1;
				}
			}
		}
		//

		int cnt = 0;
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				if (map[i][j] == 1)
					cnt++;
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}
