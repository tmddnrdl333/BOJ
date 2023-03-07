package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,664kb
// 76ms

public class Main_1021_회전하는_큐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		boolean[] isBlank = new boolean[N];
		int pointer = 0;
		int cnt = 0;

		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken()) - 1;

			// 앞으로 가는 방법
			int fPointer = pointer;
			int fCnt = 0;
			while (fPointer != target) {
				fPointer = (fPointer + N - 1) % N;
				if (!isBlank[fPointer])
					fCnt++;
			}
			// 뒤로 가는 방법
			int bPointer = pointer;
			int bCnt = 0;
			while (bPointer != target) {
				bPointer = (bPointer + 1) % N;
				if (!isBlank[bPointer])
					bCnt++;
			}

			// 앞이 빠르다
			if (fCnt < bCnt)
				cnt += fCnt;
			// 뒤가 빠르다 (혹은 같다)
			else
				cnt += bCnt;

			// 다음으로 가장 먼저 등장하는 비어있지 않은 칸에 포인터 위치
			pointer = target;
			isBlank[pointer] = true;
			for (int j = 0; j < N; j++) {
				if (isBlank[pointer])
					pointer = (pointer + 1) % N;
				else
					break;
			}
		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();

	}
}