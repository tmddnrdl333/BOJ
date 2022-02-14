package boj0214;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// boj 20299 3대측정
// 202016kb
// 720ms

public class Main_20299_3대_측정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder
		int res = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N 신청 팀 수 , S 능력 합 최소 조건 , M 개인 능력 최소 조건
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			// 각 팀원의 능력을 입력받음 (x1, x2, x3)
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			// 개인 능력 최소 조건 미달성 참가자 존재 시 건너뛰기
			if (x1 < M || x2 < M || x3 < M)
				continue;
			// 능력 합 최소 조건 달성시, 달성 팀 개수+1, 팀원들 능력 기록.
			if (x1 + x2 + x3 >= S) {
				res++;
				sb.append(x1 + " " + x2 + " " + x3 + " ");
			}
		}
		// 결과 출력
		bw.write(res + "\n" + sb.toString());
		bw.flush();
		bw.close();

	}
}
