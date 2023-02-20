package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 34,428kb
// 584ms

public class Main_18111_마인크래프트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, B;
	static int[][] map;

	static int bSum = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		B = Integer.parseInt(st.nextToken());

		// 가장 낮은 값과 가장 높은 값 기록
		int minh = Integer.MAX_VALUE;
		int maxh = 0;
		// 블럭 총 갯수 누적 : bSum
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int curh = Integer.parseInt(st.nextToken());
				map[i][j] = curh;
				minh = curh < minh ? curh : minh;
				maxh = curh > maxh ? curh : maxh;
				bSum += curh;
			}
		}
		int mint = Integer.MAX_VALUE;
		int height = 0;
		for (int h = maxh; h >= minh; h--) {
			// 놓여 있는 블럭 + 인벤토리 블럭 >= 목표 높이 필요 블럭
			if (bSum + B >= h * M * N) {
				// 가능
				int curt = plane(h);
				if (curt < mint) {
					mint = curt;
					height = h;
				}
			}
		}
		bw.write(mint + " " + height);
		bw.flush();
		bw.close();
	}

	public static int plane(int h) {
		int time = 0;
		// 높으면 깎으면서 인벤토리에 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > h) {
					time += 2 * (map[i][j] - h);
					B += map[i][j] - h;
				}
			}
		}
		// 낮은 곳 쌓아올리기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] < h) {
					time += h - map[i][j];
					// 쌓을 수 있음은 이미 검증됐으니까 굳이 인벤토리에서 빼주지 않기
				}
			}
		}
		return time;
	}
}