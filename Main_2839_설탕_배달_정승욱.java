package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,612kb
// 80ms

public class Main_2839_설탕_배달_정승욱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		int fives = N / 5; // 최대 들어가는 5의 수

		bw.write(calc(fives) + "");
		bw.flush();
		bw.close();
	}

	public static int calc(int fives) {
		if (fives == -1)
			return -1;
		int left = N - fives * 5;
		if (left % 3 == 0)
			return left / 3 + fives;
		else
			return calc(fives - 1);
	}
}
