package study.day0303;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,424kb
// 400ms

public class Main_20055_컨베이어_벨트_위의_로봇 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	// 2N크기 배열, 올리는 위치 0시작, 내리는 위치 N-1시작해서 1씩 증가, mod연산
	static int[] belt;
	// 2N크기 배열, 0+i ~ N-1+i 사이에만 로봇 존재 가능
	static boolean[] robot;

	static int pi, ti;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N];
		robot = new boolean[2 * N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++)
			belt[i] = Integer.parseInt(st.nextToken());

		int cnt = 1;
		while (act()) {
			cnt++;
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}

	public static boolean act() {
		// 1. 한 칸 회전
		pi = (pi + 2 * N - 1) % (2 * N); // 올릴 인덱스
		ti = (pi + N - 1) % (2 * N); // 내릴 인덱스 (+N-1)
		if (robot[ti]) // 내릴 인덱스에 로봇 있으면 내리기
			robot[ti] = false;
		if (robot[(ti + 1) % (2 * N)])
			robot[(ti + 1) % (2 * N)] = false;
		// 2. 로봇 이동 가능하면 이동하기
		int i = (ti + 2 * N - 1) % (2 * N); // 내리는 앞
		while (i != pi) {
			int ni = (i + 1) % (2 * N); // 다음 칸
			// 로봇이 있고, 앞이 내구도 1이상이면 전진
			if (robot[i] && !robot[ni] && belt[ni] > 0) {
				robot[i] = false;
				if (i != ti) { // 만약 다음 칸 안밟고 바로 나간다면 처리 불필요
					robot[ni] = true;
					belt[ni]--;
				}
			}
			i = (i + 2 * N - 1) % (2 * N);
		}
		// 3. 로봇 올릴 수 있으면 올리기
		// - 0위치 내구도 1이상이고, 로봇이 없다면 : 내구도--, 로봇 탑승
		if (belt[pi] > 0 && !robot[pi]) {
			belt[pi]--;
			robot[pi] = true;
		}
		int breakCnt = 0;
		for (int b = 0; b < 2 * N; b++) {
			if (belt[b] == 0) {
				breakCnt++;
			}
		}
		if (breakCnt >= K)
			return false;

		return true;
	}

}