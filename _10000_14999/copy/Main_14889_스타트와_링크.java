package ps.BOJ._10000_14999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 16,396kb
// 288ms

public class Main_14889_스타트와_링크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N;
	static int[][] S;

	static int[] pick;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				S[i][j] = Integer.parseInt(st.nextToken());
		}

		// 오른쪽 위로 다 통합. (이제 반대편은 안봐도 됨)
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				S[i][j] += S[j][i];

		// N명 중 N/2명을 골라야 하지만
		// 마지막 한 사람은 이미 골랐다고 치고
		// N-1명 중 N/2-1명만 고를 것임
		pick = new int[N];
		for (int i = N / 2; i < N - 1; i++)
			pick[i] = 1;

		int min = Integer.MAX_VALUE;
		do {
			pick[N - 1] = 1;
			// 행동
			int score0 = 0, score1 = 0;
			for (int i = 0; i < N - 1; i++) {
				if (pick[i] == 0) {
					for (int j = i + 1; j < N; j++) {
						if (pick[j] == 0) {
							score0 += S[i][j];
						}
					}
				} else {
					for (int j = i + 1; j < N; j++) {
						if (pick[j] == 1) {
							score1 += S[i][j];
						}
					}
				}
			}
			int temp = Math.abs(score0 - score1);
			min = temp < min ? temp : min;
			// 행동
			pick[N - 1] = 0;
		} while (np());
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}

	public static boolean np() {
		// 1. 교환위치 찾기
		int i = N - 2;
		while (i > 0 && pick[i - 1] >= pick[i])
			--i;

		if (i == 0)
			return false;

		// 2. 교환위치와 교환할 큰 값 위치 찾기
		int j = N - 2;
		while (pick[i - 1] >= pick[j])
			--j;

		// 3. 교환하기
		swap(i - 1, j);

		// 4. 꼭대기 뒤로 오름차순 정렬
		int k = N - 2;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void swap(int i, int j) {
		int temp = pick[i];
		pick[i] = pick[j];
		pick[j] = temp;
	}

}