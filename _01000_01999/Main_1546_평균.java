package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 13,104kb
// 88ms

public class Main_1546_평균 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		double max = 0;
		double[] arr = new double[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			max = arr[i] > max ? arr[i] : max;
		}
		double sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i] / max * 100;
			sum += arr[i];
		}
		bw.write(sum / N + "");
		bw.flush();
		bw.close();
	}
}