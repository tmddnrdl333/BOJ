package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 17956kb
// 360ms

public class Main_1007_벡터_매칭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] pts = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				pts[i][0] = x;
				pts[i][1] = y;
			}
			arr = new int[N];
			for (int i = N / 2; i < N; i++)
				arr[i] = 1;

			double output = Double.MAX_VALUE;
			do {
				int x1Sum = 0, y1Sum = 0;
				int x2Sum = 0, y2Sum = 0;
				for (int i = 0; i < N; i++) {
					if (arr[i] == 0) {
						x1Sum += pts[i][0];
						y1Sum += pts[i][1];
					} else {
						x2Sum += pts[i][0];
						y2Sum += pts[i][1];
					}
				}
				double res = Math.sqrt(Math.pow(x1Sum - x2Sum, 2) + Math.pow(y1Sum - y2Sum, 2));
				output = res < output ? res : output;
			} while (np());
			int ip = (int) output;
			double fp = output - ip;
			fp = Math.round(fp * Math.pow(10, 8)) / Math.pow(10, 8);
			output = ip + fp;
			sb.append(output + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static boolean np() {
		// 1. 교환위치 찾기
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;

		if (i < 2)
			return false;

		// 2. 교환위치와 교환할 큰 값 위치 찾기
		int j = N - 1;
		while (arr[i - 1] >= arr[j])
			--j;

		// 3. 교환하기
		swap(i - 1, j);

		// 4. 꼭대기 뒤로 오름차순 정렬
		int k = N - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}