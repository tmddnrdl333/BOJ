package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11596kb
// 76ms

public class Main_2961_도영이가_만든_맛있는_음식_정승욱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] score = new int[N][2]; // 0 sour / 1 bitter
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			score[i][0] = Integer.parseInt(st.nextToken());
			score[i][1] = Integer.parseInt(st.nextToken());
		}

		// flag = 1 ~ 2^N-1
		// 000001 부터
		// 111111 까지 (N-1자리)
		int max = (int) Math.pow(2, N) - 1;
		int res = Integer.MAX_VALUE;
		for (int flag = 1; flag <= max; flag++) {
			int sour = 1;
			int bitter = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					sour *= score[i][0];
					bitter += score[i][1];
				}
			}
			int abssum = Math.abs(sour - bitter);
			res = (abssum < res) ? abssum : res;
		}
		bw.write(res + "");
		bw.flush();
		bw.close();
	}

}
