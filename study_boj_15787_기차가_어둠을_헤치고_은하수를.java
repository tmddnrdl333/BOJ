package study.day0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 45,792kb
// 372ms

public class study_boj_15787_기차가_어둠을_헤치고_은하수를 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] command = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0] = Integer.parseInt(st.nextToken());
			command[i][1] = Integer.parseInt(st.nextToken());
			if (command[i][0] < 3) {
				command[i][2] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝

		// 각 기차 상태 저장
		int[] train = new int[N];
		// 비트형, 20 19 ... 3 2 1 이런식

		// 20 이상은 뒤를 잘라주기 위해
		// 2진법 표현 시 20개의 1로 나타나는 수 생성

		for (int i = 0; i < M; i++) {
			if (command[i][0] == 1) {
				train[command[i][1] - 1] |= 1 << command[i][2] - 1;
			} else if (command[i][0] == 2) {
				if ((train[command[i][1] - 1] & 1 << command[i][2] - 1) != 0)
					train[command[i][1] - 1] ^= 1 << command[i][2] - 1;
			} else if (command[i][0] == 3) {
				train[command[i][1] - 1] <<= 1;
				if ((train[command[i][1] - 1] & 1 << 20) != 0)
					train[command[i][1] - 1] ^= 1 << 20;
			} else {
				train[command[i][1] - 1] >>= 1;
			}
		}

		// 중복 자동 삭제용 set
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.toBinaryString(train[i]));
		}
		bw.write(Integer.toString(set.size()));
		bw.flush();
		bw.close();

		//
	}
}
