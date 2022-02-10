package IM_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj08_2527 {
	static int[] s1;
	static int[] s2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			s1 = new int[4];
			s2 = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				s1[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 4; j++) {
				s2[j] = Integer.parseInt(st.nextToken());
			}
			int a = xlineCase(s2[1]); // 2 직사각형의 아랫라인이 1 직사각형에 대해 상대위치 1~5
			int b = xlineCase(s2[3]); // 2 직사각형의 윗라인이 1 직사각형에 대해 상대위치 1~5
			int c = ylineCase(s2[0]); // 2 직사각형의 왼라인이 1 직사각형에 대해 상대위치 1~5
			int d = ylineCase(s2[2]); // 2 직사각형의 오른라인이 1 직사각형에 대해 상대위치 1~5
			char res = 'a';
			if (a == 5 || b == 1 || c == 5 || d == 1) { // 없음
				res = 'd';
			} else if (a == 4 && (c == 4 || d == 2) || b == 2 && (d == 2 || c == 4)) { // 점
				res = 'c';
			} else if ((a == 4 || b == 2) && c < 4 && d > 2) { // 선1
				res = 'b';
			} else if (a < 4 && b > 2 && (c == 4 || d == 2)) { // 선2
				res = 'b';
			}

			System.out.println(res);
		}
	}

	public static int xlineCase(int a) {
		if (a < s1[1])
			return 1;
		else if (a == s1[1])
			return 2;
		else if (a < s1[3])
			return 3;
		else if (a == s1[3])
			return 4;
		else
			return 5;
	}

	public static int ylineCase(int a) {
		if (a < s1[0])
			return 1;
		else if (a == s1[0])
			return 2;
		else if (a < s1[2])
			return 3;
		else if (a == s1[2])
			return 4;
		else
			return 5;
	}

}
