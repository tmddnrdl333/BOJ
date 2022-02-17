package algorithm_hw.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,076kb
// 920ms

public class Main_1987_알파벳_정승욱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int R, C;
	static char[][] map; // 맵
	static int[][] d = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 그대로 상 하 좌 우
	static int max = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		int selFlag = 0;
		// 맵 구성 끝

		// 시작해보자.
		// time = 0 (다음 이동이 제자리, 다음 이동 가능할때마다 +1)
		// dir = 0(제자리)
		// r = 0, c = 0 (좌상단)
		// selFlag = 0 (아무것도 선택하지 않은 상황)
		checkNMove(0, 0, 0, 0, selFlag);
		//
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();

	}

	// 지금 내가 온 곳이 가능했을까? 가능했다면 시간을 증가시켜 기록한다.
	// - 처음에는 dir에 0을 넣은 것은, 0초에서 1초로 갈 때 제자리 이동한다고 취급하기 때문
	// - 그 다음부터는 1~4까지의 이동을 할 예정
	public static void checkNMove(int time, int dir, int r, int c, int selFlag) {

		// 이동
		r += d[dir][0];
		c += d[dir][1];
		if (r < 0 || c < 0 || r >= R || c >= C) {
			return;
		}

		// 도착한 칸에 대하여...
		// 가능한 칸이었나?
		int idx = map[r][c] - 'A';
		if ((selFlag & 1 << idx) != 0) {// 오면 안되는 칸에 왔다.
			return;
		} else { // 와도 되는 칸이었다. 체크하고 다음으로
			selFlag |= 1 << idx;
			time++;
			max = time > max ? time : max; // 최대였으면 갱신
			for (int i = 1; i <= 4; i++) // 4 방향에 대해 이동
				checkNMove(time, i, r, c, selFlag);
		}

	}

}
