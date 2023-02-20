package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,624kb
// 92ms

public class Main_1038_감소하는_수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] arr = new int[10];

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		if (n > 1022) {
			bw.write("-1");
			bw.flush();
			bw.close();
			return;
		}

		int nth = 1; // 자릿수
		int cnt = 0; // 몇 번째인지
		StringBuilder sb = new StringBuilder();

		w: while (true) {
			// 배열 초기화
			for (int j = 0; j < 10; j++) {
				if (j >= (10 - nth))
					arr[j] = 1;
				else
					arr[j] = 0;
			}

			do {
				if (cnt == n) {
					for (int j = 0; j < 10; j++) {
						if (arr[j] == 1)
							sb.append((9 - j));
					}
					break w;
				}
				cnt++;
			} while (np());
			nth++;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static boolean np() {
		// 1. 교환위치 찾기
		int i = 9;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;

		if (i == 0)
			return false;

		// 2. 교환위치와 교환할 큰 값 위치 찾기
		int j = 9;
		while (arr[i - 1] >= arr[j])
			--j;

		// 3. 교환하기
		swap(i - 1, j);

		// 4. 꼭대기 뒤로 오름차순 정렬
		int k = 9;
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