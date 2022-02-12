package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12116kb
// 88ms

public class boj16_2304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] L = new int[N];
		int[] H = new int[N];
		int maxH = 0, midIdx = 0;
		int minIdx = 1000, maxIdx = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L[i] = Integer.parseInt(st.nextToken());
			H[i] = Integer.parseInt(st.nextToken());
			minIdx = L[i] < minIdx ? L[i] : minIdx;
			maxIdx = L[i] > maxIdx ? L[i] : maxIdx;
			if (H[i] > maxH) {
				maxH = H[i];
				midIdx = L[i];
			}
		}
		int[] map = new int[maxIdx - minIdx + 1];
		for (int i = 0; i < N; i++) {
			map[L[i] - minIdx] = H[i];
		}
		for (int i = 1; i < midIdx - minIdx; i++) {
			map[i] = map[i] < map[i - 1] ? map[i - 1] : map[i];
		}
		for (int i = maxIdx - minIdx - 1; i > midIdx - minIdx; i--) {
			map[i] = map[i] < map[i + 1] ? map[i + 1] : map[i];
		}
		int sum = 0;
		for (int i = 0; i < maxIdx - minIdx + 1; i++) {
			sum += map[i];
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}
