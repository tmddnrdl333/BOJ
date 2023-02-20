package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,584kb
// 80ms

public class Main_17291_새끼치기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][2];

		arr[1][0] = 1;
		arr[1][1] = 1;

		for (int i = 2; i <= N; i++) {
			arr[i][0] = arr[i - 1][1];
			arr[i][1] = arr[i][0] * 2;
			if (i >= 4 && i % 2 == 0)
				arr[i][1] -= (arr[i - 4][0] + arr[i - 3][0]);
		}

		bw.write(arr[N][1] + "");
		bw.flush();
		bw.close();
	}
}