package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 41,496kb
// 336ms

public class Main_15922_아우으_우아으이야 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int sum = 0;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int prevA = Integer.parseInt(st.nextToken()), prevB = Integer.parseInt(st.nextToken());
		int curSum = prevB - prevA;

		int curA = 0, curB = 0;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			curA = Integer.parseInt(st.nextToken());
			curB = Integer.parseInt(st.nextToken());
			// 1. 속함 -> 무시
			if (curB <= prevB) {
				// 아무 일도 없음
			}
			// 2. 연장시킴 -> B만 연장
			else if (curA <= prevB && curB > prevB) {
				curSum += curB - prevB;
				prevB = curB;
			}
			// 3. 단절 -> sum에 더하고 새로 시작
			else if (curA > prevB) {
				sum += curSum;
				curSum = curB - curA;
				prevA = curA;
				prevB = curB;
			}
		}
		sum += curSum;
		System.out.println(sum);
	}
}