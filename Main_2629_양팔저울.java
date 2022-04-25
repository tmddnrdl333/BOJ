package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,832kb
// 100ms

public class Main_2629_양팔저울 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(); // 결과 저장할 스트링빌더

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()); // 추의 개수 (<=30개)
		int[] Ns = new int[N + 1]; // 추의 무게를 저장할 배열 (<=500그램)
		st = new StringTokenizer(br.readLine());
		int sum = 0; // 추의 무게 합 (최고로 만들 수 있는 무게) (<=15000그램)
		for (int i = 1; i <= N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			Ns[i] = cur;
			sum += cur; // 무게 합 누적
		}

		// 동적 테이블 생성
		// i 행 : i번째 무게 추를 추가적용했을 때 (Ns[i]그램의 무게추)
		// j 열 : j그램의 무게를 달아낼 수 있는지 (t/f)
		boolean[][] dp = new boolean[N + 1][sum + 1];
		for (int i = 1; i <= N; i++) {
			int cur = Ns[i]; // 이번에 적용할 무게추의 무게
			for (int j = 1; j <= sum; j++) {
				if (dp[i - 1][j]) // 적용하지 않아도 이미 가능했다면 true
					dp[i][j] = true;
				else if (j == cur) // 이번에 적용할 추 하나로도 가능하면 true
					dp[i][j] = true;
				else if (dp[i - 1][Math.abs(j - cur)]) // 전에 가능했던 무게에 지금 추를 반대편에 추가하면 되는 경우 true
					dp[i][j] = true;
				else if (j + cur <= sum && dp[i - 1][j + cur]) // 전에 가능했던 무게에 지금 추를 구슬편에 추가하면 되는 경우 true
					dp[i][j] = true;
			}
		}

//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j <= sum; j++)
//				System.out.print(dp[i][j] ? "1 " : "0 ");
//			System.out.println();
//		}

		int M = Integer.parseInt(br.readLine()); // 구슬 개수 (<=7개)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (cur <= sum && dp[N][cur]) // 모든 구슬을 사용한 무게보다 적으며, 가능했던 경우라면 Y
				sb.append("Y ");
			else // 그 외 N
				sb.append("N ");
		}
		// 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
