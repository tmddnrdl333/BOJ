package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11648kb
// 72ms

public class boj14_2628 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(br.readLine());
		int wCnt = 1, hCnt = 1;
		int[] wArr = new int[W];
		int[] hArr = new int[H];
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			if (tmp1 == 0) {
				if (hArr[tmp2] == 0) {
					hCnt++;
					hArr[tmp2]++;
				}
			} else {
				if (wArr[tmp2] == 0) {
					wCnt++;
					wArr[tmp2]++;
				}
			}
		}
		int[] widths = new int[wCnt];
		int[] heights = new int[hCnt];
		int tmp = 0;
		for (int i = 0; i < W; i++) {
			if (wArr[i] == 1)
				tmp++;
			widths[tmp]++;
		}
		tmp = 0;
		for (int i = 0; i < H; i++) {
			if (hArr[i] == 1)
				tmp++;
			heights[tmp]++;
		}
		int max = 0;
		for (int i = 0; i < wCnt; i++) {
			for (int j = 0; j < hCnt; j++) {
				int size = widths[i] * heights[j];
				max = size > max ? size : max;
			}
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}
