package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 21880kb
// 192ms

public class boj17_2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] sum = new int[N - K + 1];
		for (int i = 0; i < K; i++) {
			sum[0] += arr[i];
		}
		int max = sum[0];
		for (int i = 1; i < N - K + 1; i++) {
			sum[i] = sum[i - 1] - arr[i - 1] + arr[i - 1 + K];
			max = sum[i] > max ? sum[i] : max;
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}
