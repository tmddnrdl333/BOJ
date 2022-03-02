package study.day0302;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11,916kb
// 84ms

public class Main_11399_ATM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			arr[i] = sum;
		}
		sum = 0;
		for (int i = 0; i < N; i++)
			sum += arr[i];

		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();

	}
}