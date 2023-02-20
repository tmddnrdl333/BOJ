package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 17,692kb
// 108ms

public class Main_11656_접미사_배열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int len = str.length();
		String[] arr = new String[len];
		for (int i = 0; i < len; i++)
			arr[i] = str.substring(i);
		Arrays.sort(arr);
		for (int i = 0; i < len; i++)
			sb.append(arr[i]).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}