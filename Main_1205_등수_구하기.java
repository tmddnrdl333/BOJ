package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,640kb
// 80ms

public class Main_1205_등수_구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if (N != 0)
			st = new StringTokenizer(br.readLine());
		int res = 1, cnt = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp > score)
				res++;
			if (tmp >= score)
				cnt++;
			if (res > P || cnt == P) {
				res = -1;
				break;
			}
		}
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}