package ps.BOJ._20000_29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,096kb
// 96mss

public class Main_20207_달력 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[366];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
			for (int j = s; j <= e; j++)
				arr[j]++;
		}

		int w = 0, h = 0;
		int sum = 0;
		for (int i = 1; i <= 365; i++) {
			if (arr[i] != 0) {
				w++;
				h = arr[i] > h ? arr[i] : h;
			} else {
				sum += w * h;
				w = 0;
				h = 0;
			}
		}
		sum += w * h;

		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}