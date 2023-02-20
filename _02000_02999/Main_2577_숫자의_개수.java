package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2577_숫자의_개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		int res = a * b * c;
		while (res != 0) {
			arr[res % 10]++;
			res /= 10;
		}
		for (int i = 0; i < 10; i++) {
			sb.append(arr[i] + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}