package ps.BOJ._04000_04999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,024kb
// 84ms

public class Main_4386_별자리_만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static float[][] pts;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		pts = new float[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pts[i][0] = Float.parseFloat(st.nextToken());
			pts[i][1] = Float.parseFloat(st.nextToken());
		}
		float[][] aM = new float[N][N];
		float[] mE = new float[N];
		boolean[] v = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				float res = (float) Math.sqrt(Math.pow(pts[i][0] - pts[j][0], 2) + Math.pow(pts[i][1] - pts[j][1], 2));
				aM[i][j] = res;
				aM[j][i] = res;
			}
			mE[i] = Float.MAX_VALUE;
		}

		float res = 0;
		mE[0] = 0;

		for (int c = 0; c < N; c++) {
			float min = Float.MAX_VALUE;
			int minV = 0;
			for (int i = 0; i < N; i++) {
				if (!v[i] && min > mE[i]) {
					min = mE[i];
					minV = i;
				}
			}

			v[minV] = true;
			res += min;

			for (int i = 0; i < N; i++) {
				if (!v[i] && aM[minV][i] != 0 && mE[i] > aM[minV][i]) {
					mE[i] = aM[minV][i];
				}
			}
		}

		System.out.printf("%.2f", res);
	}
}