package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11,844kb
// 84ms

public class Main_1389_케빈_베이컨의_6단계_법칙 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static final int INF = 100;

	static int N, M;
	static int[][] aM;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		aM = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(aM[i], INF); // 관계 없으면 INF
			aM[i][i] = 0; // 자기자신은 0
		}
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
			aM[a][b] = 1;
			aM[b][a] = 1; // 인접은 1거리
		}

		// f-w
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < N; j++) {
					if (i == j || j == k)
						continue;
					if (aM[i][j] > aM[i][k] + aM[k][j])
						aM[i][j] = aM[i][k] + aM[k][j];
				}
			}
		}
		int min = INF, ans = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++)
				sum += aM[i][j];
			if (sum < min) {
				min = sum;
				ans = i + 1;
			}
		}
		System.out.println(ans);
	}

}