package study.day0303;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 18,260kb
// 224ms

public class Main_1339_단어_수학 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static char[][] input;
	static int[][] score = new int[26][2];

	static int result = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		input = new char[N][8]; // 뒤부터 채우기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int len = str.length();
			for (int j = 0; j < len; j++) {
				input[i][7 - j] = str.charAt(len - 1 - j);
			}
		}
		rateNum();
		calc();
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
	}

	public static void rateNum() {
		for (int c = 0; c < 8; c++) {
			for (int r = 0; r < N; r++) {
				char cur = input[r][c];
				if (cur != 0) {
					score[cur - 'A'][0] += Math.pow(10, 7 - c);
				}
			}
		}
		for (int i = 0; i < 26; i++)
			score[i][1] = i;

	}

	public static void calc() {
		// rate배열에는 0열에 점수, 1열에 알파벳정보가 들어있음
		Arrays.sort(score, (o1, o2) -> o2[0] - o1[0]);
		for (int i = 0; i < 10; i++)
			score[i][0] = 9 - i;
		Arrays.sort(score, (o1, o2) -> o1[1] - o2[1]);

		for (int r = 0; r < N; r++)
			for (int c = 0; c < 8; c++) {
				char cur = input[r][c];
				if (cur != 0)
					result += Math.pow(10, 7 - c) * score[cur - 'A'][0];
			}
	}

}