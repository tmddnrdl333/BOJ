package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 16,944kb
// 212ms

public class Main_17406_배열_돌리기_4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, K;
	static int[][] A, B;
	static int[][] command;
	static int[] seq;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		B = new int[N][M];
		command = new int[K][3];
		seq = new int[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				B[i][j] = A[i][j];
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				command[i][j] = Integer.parseInt(st.nextToken()) - 1;
		}

		// 순서 초기화
		for (int i = 0; i < K; i++) {
			seq[i] = i;
		}
		do {
			for (int idx : seq) {
				operate(idx);
			}
			// 계산
			int partMin = getValue();
			min = partMin < min ? partMin : min;
			// A초기화
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					A[i][j] = B[i][j];
		} while (np());

		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 }; // 우 하 좌 상

	public static void operate(int idx) {
		int s = command[idx][2] + 1;
		for (; s > 0; s--) {
			int r = command[idx][0] - s;
			int c = command[idx][1] - s;
			int prev = A[r][c];
			for (int dir = 0; dir < 4; dir++) {
				for (int i = 0; i < 2 * s; i++) {
					r += dr[dir];
					c += dc[dir];
					int cur = A[r][c];
					A[r][c] = prev;
					prev = cur;
				}
			}
		}
	}

	public static int getValue() {
		int partMin = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += A[i][j];
			}
			partMin = sum < partMin ? sum : partMin;
		}
		return partMin;
	}

	public static boolean np() {
		// 1. 교환위치 찾기
		int i = K - 1;
		while (i > 0 && seq[i - 1] >= seq[i])
			--i;

		if (i == 0)
			return false;

		// 2. 교환위치와 교환할 큰 값 위치 찾기
		int j = K - 1;
		while (seq[i - 1] >= seq[j])
			--j;

		// 3. 교환하기
		swap(i - 1, j);

		// 4. 꼭대기 뒤로 오름차순 정렬
		int k = K - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void swap(int i, int j) {
		int temp = seq[i];
		seq[i] = seq[j];
		seq[j] = temp;
	}
}