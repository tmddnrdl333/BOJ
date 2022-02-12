package boj0212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11572kb
// 76ms

public class Main_12927_배수스위치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] input = br.readLine().toCharArray();
		int len = input.length;
		int[] arr = new int[len + 1];
		for (int i = 0; i < len; i++) {
			if (input[i] == 'Y')
				arr[i + 1] = 1;
		}
		int cnt = 0;
		for (int i = 1; i <= len; i++) {
			if (arr[i] == 1) {
				for (int j = i; j <= len; j += i)
					arr[j] = 1 - arr[j];
				cnt++;
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}
