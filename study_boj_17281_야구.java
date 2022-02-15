package study.day0214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 17524kb
// 704ms

public class study_boj_17281_야구 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] arr;
	static int[] player, realplayer;

	public static void main(String[] args) throws IOException {
		// 입력
		// N : 이닝 수
		int N = Integer.parseInt(br.readLine());
		// arr : 이닝 별 선수들 기대 성적
		arr = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 선수 번호 초기화
		// player는 4번타자를 제외한 순열을 돌릴 선수들의 배열
		player = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		// realplayer는 4번타자를 자리에 넣어주기만 할 진짜 순서의 배열
		realplayer = new int[9];

		// 선수 순열로 순서 바꿔가며 점수 계산
		// np
		int max = 0; // 각 순열별 score 계산 후 최대만 max에 저장
		do {
			// 4번 타자 끼워넣기
			for (int i = 0; i < 3; i++)
				realplayer[i] = player[i];
			realplayer[3] = 0;
			for (int i = 4; i < 9; i++)
				realplayer[i] = player[i - 1];

			// ===== 각 순열 별 점수 계산 알고리즘 =====

			// 타자 인덱스 (0 시작)
			int playerIdx = 0;
			// 순열 별 점수
			int score = 0;

			for (int i = 0; i < N; i++) {
				// 이닝별 아웃카운트
				int outcnt = 0;
				// 이닝별 주자상황 (2진법, 1111 : 홈 3루 2루 1루)
				int flag = 0;
				while (true) {
					// player배열은 타자 순서를 나타내는 배열.
					// 4번 타자가(idx=3) 1번 선수가 아니면 건너뛰기

					// player[playerIdx] : player 배열의 playerIdx번째는 실제 타자의 인덱스값
					int rec = arr[i][realplayer[playerIdx]];
					if (rec == 0) { // 아웃
						outcnt++;
						playerIdx = (playerIdx + 1) % 9;
						if (outcnt == 3) // 3아웃 시 다음 이닝으로
							break;
						continue;
					} else {
						// 1루타면 1루씩 전진, 홈런이면 다 4칸씩 전진
						flag <<= rec;
						
						// 1루타면 1루에 진루, 홈런이면 홈 칸에 1
						flag |= 1 << rec - 1;
					}

					// 홈에 들어온 사람 한 명당 1점
					for (int home = 0; home < 4; home++) {
						if ((flag & 8 << home) != 0) {
							score++;
							flag -= (8 << home);
						}
					}

					playerIdx = (playerIdx + 1) % 9;
				}
			}
			max = score > max ? score : max;

			// ================================
		} while (np());

		bw.write(max + "");
		bw.flush();
		bw.close();
	}

	private static boolean np() {
		// 1. 교환 위치 찾기
		int i = 7;
		while (i > 0 && player[i - 1] >= player[i])
			--i;
		if (i == 0)
			return false; // 완성된 상황

		// 2. 교환 위치에 교환할 값 찾기
		int j = 7;
		while (player[i - 1] >= player[j])
			--j;

		// 3. 교환 위치와 교환할 값 교환하기
		int temp = player[i - 1];
		player[i - 1] = player[j];
		player[j] = temp;

		// 4. 교환 위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순 정렬)
		int k = 7;
		while (i < k) {
			temp = player[i];
			player[i] = player[k];
			player[k] = temp;
			i++;
			k--;
		}
		return true;
	}

}
