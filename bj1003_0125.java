package bj_0125;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1003_0125 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(bf.readLine()); // 케이스 수
		int[] N = new int[T]; // 케이스 별로 입력받을 배열

		int max = 0;

		for (int i = 0; i < T; i++) {
			N[i] = Integer.parseInt(bf.readLine());
			max = (N[i] > max) ? N[i] : max;
		}

		int[][] num = new int[max + 1][2];
		num[0][0] = 1;
		num[0][1] = 0;
		for (int i = 1; i <= max; i++) {
			num[i][0] = num[i - 1][1];
			num[i][1] = num[i - 1][1] + num[i - 1][0];
		}

		for (int i = 0; i < T; i++) {
			String str = Integer.toString(num[N[i]][0]) + " " + Integer.toString(num[N[i]][1]);
			bw.write(str + "\n");
		}
		bw.flush();
		bw.close();
	}

}
