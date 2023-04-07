package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,916kb
// 108ms

public class Main_14890_경사로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		L = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int res = 0;
		for (int i = 0; i < N; i++) {

			// 횡
			boolean xFlag = true;
			boolean[] xPlaced = new boolean[N];
			// 좌에서 우로 내려가는 것만
			for (int j = 1; j < N; j++) {
				// 01. (성공)경사로 없어도 됨
				if (map[i][j - 1] == map[i][j])
					continue;
				// 02. 한칸 차이일 경우
				else if (map[i][j - 1] - 1 == map[i][j]) {
					int pre = map[i][j - 1];
					// L 칸 만큼 놓아야 함
					for (int k = 0; k < L; k++) {
						int nj = j + k;
						// 02-01. (실패)경사로를 놓을 칸이 부족
						if (nj >= N)
							xFlag = false;
						// 02-02. (실패)이미 경사로가 놓여있음
						else if (xPlaced[nj])
							xFlag = false;
						// 02-03. (실패)경사로를 놓을 칸의 높이가 다름
						else if (map[i][nj] != pre - 1)
							xFlag = false;
						// 02-04. (성공)위 실패조건 모두 통과 -> 놓기
						else
							xPlaced[nj] = true;
					}
					// L 칸 만큼 건너뛰기
					j += L - 1;
				}
				// 03. (실패)한 칸 이상 차이날 경우
				else if (map[i][j - 1] - 1 > map[i][j])
					xFlag = false;
			}

			// 우에서 좌로 내려가는 것만
			for (int j = N - 2; j >= 0; j--) {
				if (map[i][j + 1] == map[i][j])
					continue;
				else if (map[i][j + 1] - 1 == map[i][j]) {
					int pre = map[i][j + 1];
					for (int k = 0; k < L; k++) {
						int nj = j - k;
						if (nj < 0 || xPlaced[nj] || map[i][nj] != pre - 1)
							xFlag = false;
						else
							xPlaced[nj] = true;
					}
					j -= L - 1;
				} else if (map[i][j + 1] - 1 > map[i][j])
					xFlag = false;
			}

			if (xFlag)
				res++;

			// 종
			boolean yFlag = true;
			boolean[] yPlaced = new boolean[N];
			// 상->하
			for (int j = 1; j < N; j++) {
				if (map[j - 1][i] == map[j][i])
					continue;
				else if (map[j - 1][i] - 1 == map[j][i]) {
					int pre = map[j - 1][i];
					for (int k = 0; k < L; k++) {
						int nj = j + k;
						if (nj >= N || yPlaced[nj] || map[nj][i] != pre - 1)
							yFlag = false;
						else
							yPlaced[nj] = true;
					}
					j += L - 1;
				} else if (map[j - 1][i] - 1 > map[j][i])
					yFlag = false;
			}
			// 하->상
			for (int j = N - 2; j >= 0; j--) {
				if (map[j + 1][i] == map[j][i])
					continue;
				else if (map[j + 1][i] - 1 == map[j][i]) {
					int pre = map[j + 1][i];
					for (int k = 0; k < L; k++) {
						int nj = j - k;
						if (nj < 0 || yPlaced[nj] || map[nj][i] != pre - 1)
							yFlag = false;
						else
							yPlaced[nj] = true;
					}
					j -= L - 1;
				} else if (map[j + 1][i] - 1 > map[j][i])
					yFlag = false;
			}

			if (yFlag)
				res++;

		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}
