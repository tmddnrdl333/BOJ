package study.day0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class study_boj_1052_물병_처음시도한방법 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int K, buyCnt;

	static int[] state = new int[30]; // 1 2 4 8 16 리터 물병의 개수

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 비어있지 않은 물병의 개수
		K = Integer.parseInt(st.nextToken()); // 목표 비어있지 않은 물병의 개수
		// 입력 끝

		// N 개의 물병인데, N - N/2 해도 K보다 크다면 계속해서 반으로 접어주자
		// - N/2개는 2리터가 되고, 1 / 0 개는 1리터로 남는다.

		// N , 1
		// N/2 , 2 ( 홀이라면 + 1 , 1 )
		// N/4 , 4 ( 홀이라면 + 1 , 2 )
		// N/8 , 8 ( 홀이라면 + 1 , 4 )

		// 초기 값
		// 1리터는 N개다.
		state[0] = N;

		// test
		System.out.println(Arrays.toString(state));
		// test

		pourAndBuy();

		System.out.println(buyCnt);

	}

	// 현재 물병 개수 반환
	public static int getTotal() {
		int total = 0;
		for (int i = 0; i < 30; i++) {
			total += state[i];
		}
		return total;
	}

	public static void pourAndBuy() {

		// 현 상태에서 더 줄여야 하는 물병의 수
		int reduce = getTotal() - K;

		// 0번부터 29번 물병까지 체크
		for (int i = 0; i < 30; i++) {
			// 가장 적은 물이 담긴 물병이 둘 이상일 경우
			if (state[i] > 1) {
				// 01. i번째 물병에서:
				// - 붓는다고 해도 reduce의 할당량을 못 채우는 경우
				// - 일단 붓는다
				if (reduce >= state[i] / 2) {
					state[i + 1] += state[i] / 2; // "지금 물병 수/2"만큼 다음 크기 물병 개수를 증가
					reduce -= state[i] / 2;
					state[i] -= state[i] / 2 * 2; // 그 만큼 차감
					if (reduce == 0) { // 끝내야 함.
						break;
					}
				}
				// 02. i번째 물병에서:
				// - 일부만 부어도 reduce 할당량이 채워지는 경우
				// - 일부만 붓고 종료한다.
				else { // 끝내야 함.
					break;
				}
			}
		}
		// test
//		System.out.println(Arrays.toString(state));
		// test
		if (reduce != 0) {
//			System.out.println("물 사야되네");
			buyCnt++;
			state[0]++;
			pourAndBuy();
		}

	}
}
