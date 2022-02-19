package study.day0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,560kb
// 104ms

public class study_boj_18233_러버덕을_사랑하는_모임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, P, E; // N명 중 P명에게 E개를 주고 싶다.
	static int[][] arr; // 입력된 값으로, N명의 각각 최소와 최대 받고 싶은 개수
	static int[] pick; // 고를 수 있는 조합을 저장하는 배열
	static int resPlus; // 결과적으로 최소에서 더해줘야 하는 개수
	static boolean flag = false; // 이미 답이 나왔으면 true가 되어 더 이상 연산하지 못하게

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 최소와 더 줄수 있는 최대 개수 저장
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken()) - arr[i][0];
		}
		// 입력 끝

		// 계산
		pick = new int[P];
		combi(0, 0);

		// 출력
		if (sb.length() > 1) {
			bw.write(sb.toString());
		} else
			bw.write(Integer.toString(-1));
		bw.flush();
		bw.close();

	}

	// N명 중 P명을 뽑는 모든 경우의 수
	// 에 대하여 E개를 줄 수 있으면 주고 기억하기
	public static void combi(int cnt, int start) {
		// 기본 파트
		// P개 뽑음
		if (cnt == P) {
			// 가능한지 확인 후 가능하면 저장
			if (isAvailable()) {
				for (int i = 0; i < P; i++) {
					// 만약 이번 인덱스에서 다 더해줘서 끝낼 수 있다면
					if (arr[pick[i]][1] >= resPlus) {
						arr[pick[i]][0] += resPlus;
						arr[pick[i]][1] -= resPlus;
						resPlus = 0;
						break;
					} else { // 그렇지 않고 다음으로 넘어가야 한다면 최대한 넣어주고 감
						resPlus -= arr[pick[i]][1];
						arr[pick[i]][0] += arr[pick[i]][1];
						arr[pick[i]][1] = 0;
					}
				}
				// 저장
				int p = 0;
				for (int i = 0; i < N; i++) {
					if (p < P && pick[p] == i) {
						sb.append(arr[i][0]).append(" ");
						p++;
					} else
						sb.append("0 ");
				}
			}
			return;
		}

		// 유도 파트
		for (int i = start; i < N; i++) {
			// cnt번째에 i번째 사람 뽑기
			pick[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	public static boolean isAvailable() {

		// 이미 답이 나왔으면 하지말자
		if (flag) {
			return false;
		}

		// pick의 조합을 다 넣은 최소
		int min = 0;
		// 이 조합에 더 넣을 수 있는 최대
		int maxPlus = 0;
		for (int i = 0; i < P; i++) {
			min += arr[pick[i]][0];
			maxPlus += arr[pick[i]][1];
		}

		if (min > E) // 최소마저 E를 넘기면 불가능
			return false;
		else {
			if (min + maxPlus < E) { // 최대가 E도 안되면 불가능
				return false;
			} else { // 최소가 E보다 작거나 같으면서, 최대는 E보다 크거나 같음 : 가능
				resPlus = E - min; // 결과적으로 최소에 더해야 하는 개수
				flag = true;
				return true;
			}
		}
	}

}
