package study.day0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11,732kb
// 84ms

public class study_boj_1080_행렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int[][] A, B;
	static int cnt = 0; // 총 반전 횟수
	static boolean flag = false; // 불가능하면 true가 됨

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// A와 B를 입력받음
		A = new int[N][M];
		B = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}
		// 입력 끝

		// 계산

		// 1. 3*3보다 행이나 열이 적을 경우, 애초에 같지 않다면 무조건 틀림
		if (N < 3 || M < 3) {
			out1: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (A[i][j] != B[i][j]) {
						flag = true;
						break out1;
					}
				}
			}
			if (flag) // 같지 않았다.
				bw.write(Integer.toString(-1));
			else // 같았다.
				bw.write(Integer.toString(0));
			bw.flush();
			bw.close();
			return;
		}

		// 2. 3*3보다 행과 열이 모두 클 경우, 하나씩 비교
		// - 0~N-2, 0~M-2만 반전 가능
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j])
					reverse(i, j);
			}
			// 오른쪽 두 열은 반전할 수 없으므로 맞는지 확인해줘야 함.
			if (A[i][M - 2] != B[i][M - 2] || A[i][M - 1] != B[i][M - 1]) {
				flag = true;
				break;
			}
		}
		// 아래 두 행도 확인해줘야 함.
		out2: for (int i = N - 2; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					flag = true;
					break out2;
				}
			}
		}

		// 출력
		if (flag) // 불가능
			bw.write(Integer.toString(-1));
		else // 가능
			bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();

	}

	// 반전
	public static void reverse(int r, int c) {
		cnt++;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				A[r + i][c + j] = 1 - A[r + i][c + j];
			}
		}
	}
}
