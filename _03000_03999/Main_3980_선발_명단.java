package ps.BOJ._03000_03999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 13,236kb
// 120ms

public class Main_3980_선발_명단 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] arr = new int[11][11];
	static boolean[] picked = new boolean[11];
	static int sum = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (; TC > 0; TC--) {
			// 00. 입력
			for (int i = 0; i < 11; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}

			// 01. 선수 선택 (백트래킹)
			select(0);

			// 02. 이번 TC의 결과 입력
			sb.append(max).append("\n");

			// 03. 변수 초기화
			sum = 0;
			max = 0;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	// i번째 선수가 j번 포지션에...
	static void select(int i) {
		if (i == 11) {
			max = sum > max ? sum : max;
			return;
		}
		for (int j = 0; j < 11; j++) {
			if (arr[i][j] == 0 || picked[j])
				continue;
			else {
				sum += arr[i][j];
				picked[j] = true;
				select(i + 1);
				sum -= arr[i][j];
				picked[j] = false;
			}
		}
	}
}