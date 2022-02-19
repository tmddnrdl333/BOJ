package study.day0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11856kb
// 84ms

public class study_boj_14891_톱니바퀴 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] input = new int[4];

	public static void main(String[] args) throws IOException {
		// 입력
		// 4개 톱니바퀴
		// 12시부터 시계방향으로 8개, 0:N, 1:S
		for (int i = 0; i < 4; i++) {
			// 8자리 char로 입력받음
			char[] tmp = new char[8];
			tmp = br.readLine().toCharArray();
			// 2진 변환
			for (int j = 0; j < 8; j++) {
				input[i] += (tmp[j] - '0') << (7 - j);
			}
			input[i] <<= 1; // 오른쪽 한 칸 비워둠 (시계방향 이동 시 삭제되지 않게)
		}

		// K번 회전
		// 몇 번 톱니바퀴가 시계방향(1) 반시계방향(-1)으로 한칸
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			int cc = checkChain(); // 이 값에 따라 rotate를 몇 개 할지 정해줌
			rotate(idx, dir);
			rightWave(idx, dir, cc); // 우로 전파 (가능한 한)
			leftWave(idx, dir, cc); // 좌로 전파 (가능한 한)
		}
		int score = 0;
		for (int i = 0; i < 4; i++) {
			if ((input[i] & 1 << 8) != 0) {
				score += 1 << i;
			}
		}
		bw.write(Integer.toString(score));
		bw.flush();
		bw.close();

	}

	public static void rotate(int idx, int dir) {
		if (dir > 0) {
			// 시계
			input[idx] >>= 1;
			check(idx);
		} else {
			// 반시계
			input[idx] <<= 1;
			check(idx);
		}
	}

	// 원래 1~8칸에만 있어야 되는데, 혹시 0/9에 있으면 옮겨주기
	public static void check(int idx) {
		if ((input[idx] & 1) != 0) {
			input[idx] -= 1 << 0;
			input[idx] += 1 << 8;
		} else if ((input[idx] & 1 << 9) != 0) {
			input[idx] -= 1 << 9;
			input[idx] += 1 << 1;
		}
	}

	// 같이 움직이는 것들을 알려주는 값 반환
	// 001 : 0,1 같이 회전
	// 010 : 1,2 같이 회전
	// 100 : 2,3 같이 회전
	public static int checkChain() {
		int flag = 0;
		boolean[] left = new boolean[4];
		boolean[] right = new boolean[4];
		for (int i = 0; i < 4; i++) {
			left[i] = (input[i] & 1 << 2) != 0 ? true : false;
			right[i] = (input[i] & 1 << 6) != 0 ? true : false;
		}
		if (right[0] ^ left[1]) {
			// 0, 1 같이 회전
			flag += 1 << 0;
		}
		if (right[1] ^ left[2]) {
			// 1, 2 같이 회전
			flag += 1 << 1;
		}
		if (right[2] ^ left[3]) {
			// 2, 3 같이 회전
			flag += 1 << 2;
		}
		return flag;
	}

	// idx번 톱니에 대해, cc의 연쇄상태를 받아서,
	// cc에 따라 오른쪽을 같이 회전시키는지 확인해서
	// 해야하면 회전시키고 오른쪽도 그 오른쪽에 똑같이 적용
	// 3일 시 탈출
	public static void rightWave(int idx, int dir, int cc) {
		if (idx == 3)
			return;
		if ((cc & 1 << idx) != 0) {
			rotate(idx + 1, -dir);
			rightWave(idx + 1, -dir, cc);
		}
	}

	// idx번 톱니에 대해, cc의 연쇄상태를 받아서,
	// cc에 따라 왼쪽을 같이 회전시키는지 확인해서
	// 해야하면 회전시키고 왼쪽도 그 왼쪽에 똑같이 적용
	// 3일 시 탈출
	public static void leftWave(int idx, int dir, int cc) {
		if (idx == 0)
			return;
		if ((cc & 1 << idx - 1) != 0) {
			rotate(idx - 1, -dir);
			leftWave(idx - 1, -dir, cc);
		}
	}
}
