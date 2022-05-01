package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 17,572kb
// 152ms

public class Main_2166_다각형의_면적 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static double[][] xy;
	static double res = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		xy = new double[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N - 1; i++) {
			res += ((xy[i][0] - xy[0][0]) * (xy[i + 1][1] - xy[0][1])
					- (xy[i + 1][0] - xy[0][0]) * (xy[i][1] - xy[0][1])) / 2;
		}
		System.out.printf("%.1f", Math.abs(res));
	}
}