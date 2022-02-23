package study.day0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12072kb
// 116ms

public class study_boj_1107_리모컨 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;

	static int cnt = 0;
	static int start = 100;

	static boolean flag = false;

	static int[] broken; // 고장난 키

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 목표 값
		M = Integer.parseInt(br.readLine());
		broken = new int[M];
		if (M != 0)
			st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			broken[i] = Integer.parseInt(st.nextToken());

		// 1. '+', '-' 로만 가는 경우
		int pm = Math.abs(100 - N);

		// 2. 목표값부터 범위를 넓혀가며 가장 가까운 가능한 값 찾기
		// (1) 가능한 값을 찾은 경우
		// - 답 : 그 번호의 길이 + 넓힌 거리
		// (2) 가능한 값이 없는 경우
		// - 답 : pm
		for (int i = 0; i < 1000000; i++) {
			if (N - i >= 0 && isAvailable(N - i)) {// 목표값-i는 가능하냐?
				cnt = getLength(N - i) + i;
				break;
			}
			if (isAvailable(N + i)) {
				cnt = getLength(N + i) + i;
				break;
			}
			if (!flag) // 한 번도 available하지 못한 경우
				cnt = pm;
		}
		cnt = pm < cnt ? pm : cnt;
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();

	}

	// 가능시 true 반환
	public static boolean isAvailable(int num) {
		do {
			int temp = num % 10;
			for (int brk : broken) {
				if (temp == brk) {
					return false;
				}
			}
			num /= 10;
		} while (num != 0);
		flag = true;
		return true;
	}

	public static int getLength(int num) {
		return Integer.toString(num).length();
	}
}
