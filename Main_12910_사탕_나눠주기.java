package boj0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11656kb
// 76ms

public class Main_12910_사탕_나눠주기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[51];
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[tmp]++;
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0)
				break;
			if (i != 1)
				arr[i] *= arr[i - 1];
			sum += arr[i];
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}
