package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 19520kb
// 192ms

public class boj15_2116 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][6];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int resmax = 0;
		// 각 주사위에 대하여 위 아래를 제외한 가장 큰 값만 저장할 N칸짜리 배열
		int[] maxNum = new int[N];
		// 맨 아래 주사위의 아랫 면 인덱스에 따라 총 6개의 케이스
		for (int i = 0; i < 6; i++) { // 1번 주사위 맨 아랫 면 인덱스가 i
			Arrays.fill(maxNum, 0);
			int bot = i;
			int top = opposite(bot);
			int topnum = arr[0][top];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 6; k++) {
					if (k == bot || k == top)
						continue;
					maxNum[j] = arr[j][k] > maxNum[j] ? arr[j][k] : maxNum[j];
				}
				if (j == N - 1)
					break;
				for (int k = 0; k < 6; k++)
					if (arr[j + 1][k] == topnum) {
						bot = k;
						break;
					}
				top = opposite(bot);
				topnum = arr[j + 1][top];
			}
			int tmpsum = 0;
			for (int j = 0; j < N; j++)
				tmpsum += maxNum[j];
			resmax = tmpsum > resmax ? tmpsum : resmax;

		}
		bw.write(resmax + "");
		bw.flush();
		bw.close();
	}

	public static int opposite(int idx) {
		if (idx == 0)
			return 5;
		else if (idx == 5)
			return 0;
		else if (idx == 1 || idx == 2) {
			return idx + 2;
		} else {
			return idx - 2;
		}
	}
}
