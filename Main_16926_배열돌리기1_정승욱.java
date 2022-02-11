package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1_정승욱 {
	static int[][] A; // input
	static int[][] B; // result
	static int N, M, R, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		min = Math.min(N, M) / 2; // 총 min개의 사이클
		A = new int[N][M];
		B = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		// 0,0부터 겹칠때까지 한바퀴 돌고
		// 1,1부터 또 돌고
		// min번 반복하면 된다.
		//
		for (int j = 0; j < R; j++) {
			for (int i = 0; i < min; i++)
				rotate(i);
			copy();
		}
		//
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(A[i][j] + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void rotate(int a) {
		// A[a][a] 자리에 A[a][a+1]이 들어와야 한다.
		// A[a][M-1-a]까지 채워야 하는데 마지막 하나는 아래에서 가져와야 한다.
		for (int i = a; i < M - 1 - a; i++) {
			B[a][i] = A[a][i + 1];
		}
		for (int i = a; i < N - 1 - a; i++) {
			B[i][M - 1 - a] = A[i + 1][M - 1 - a];
		}
		for (int i = M - 1 - a; i > a; i--) {
			B[N - 1 - a][i] = A[N - 1 - a][i - 1];
		}
		for (int i = N - 1 - a; i > a; i--) {
			B[i][a] = A[i - 1][a];
		}
	}

	public static void copy() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				A[i][j] = B[i][j];
	}
}