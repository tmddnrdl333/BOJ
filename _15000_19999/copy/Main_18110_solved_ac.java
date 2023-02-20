package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 31,988kb
// 284ms

public class Main_18110_solved_ac {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int a = (int) Math.round((double) n * 15 / 100);
		int sum = 0;
		for (int i = a; i < n - a; i++)
			sum += arr[i];
		int res = (int) Math.round((double) sum / (n - 2 * a));
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}