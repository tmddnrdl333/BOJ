package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12,600kb
// 96ms

public class Main_16236_아기상어 {

	// r,c 좌표
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		// 갈 수 없으면 null반환
		public Point move(int dir) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 가능 : 벽을 넘지 않았고, 그 칸 물고기가 내 사이즈보다 작거나 같음.
			if (nr != -1 && nr != N && nc != -1 && nc != N && map[nr][nc] <= mySize)
				return new Point(nr, nc);
			// 불가능
			return null;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N; // map 크기
	static int[][] map;

	static int sec = 0; // 경과 시간
	static int cnt;

	static Point myPoint; // 상어 좌표
	static int mySize = 2; // 상어 크기
	// 상 좌 우 하 (우선순위)
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		// 입력 받기
		// 상어 좌표 저장 myPoint
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j] = 0;
					myPoint = new Point(i, j);
				}
			}
		}

		// 시작
		// bfs로 이동
		while (bfs()) {
		}

		bw.write(Integer.toString(sec));
		bw.flush();
		bw.close();
	}

	public static boolean bfs() {

		boolean flag = false; // 먹었으면 true

		map[myPoint.r][myPoint.c] += 10; // 방문

		Queue<Point> q1 = new LinkedList<>();
		Queue<Point> q2 = new LinkedList<>();

		Point destP = new Point(N, N);

		q1.add(myPoint);
		cnt = 0;
		while (!flag && !q1.isEmpty()) {
			while (!q1.isEmpty()) {
				q2.add(q1.poll());
			}
			while (!q2.isEmpty()) {
				Point p = q2.poll();
				for (int dir = 0; dir < 4; dir++) {
					Point np = p.move(dir);
					if (np != null) { // 갈 수 있는 칸인데
						int unknown = map[np.r][np.c]; // 그 칸 내용
						if (unknown > mySize) // 이미 온 칸이거나 나보다 크면 안됨
							continue;
						else if (unknown == 0 || unknown == mySize) { // 안가본 빈칸or나랑 같은 물고기
							map[np.r][np.c] += 10;
							q1.add(np);
						} else { // 내가 먹을 수 있는 물고기
							// 먹을 수 있다면 기록
							if (np.r < destP.r) {
								destP = np;
							} else if (np.r == destP.r && np.c < destP.c) {
								destP = np;
							} else {
							}
							flag = true;
						}
					} else // 갈 수 없는 칸
						continue;
				}
			}
			cnt++;
		}
		if (destP.r != N)
			eat(destP, cnt);

		// 돌려놓기
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (map[i][j] > 9)
					map[i][j] -= 10;
		return flag;
	}

	// 지금크기로 먹은 갯수
	static int ate = 0;

	// 먹고 반영
	public static void eat(Point np, int cnt) {
		map[np.r][np.c] = 0; // 맵 반영
		sec += cnt; // 시간 반영
		ate++; // 먹은 갯수 증가
		if (mySize < 10 && ate == mySize) { // 크기만큼 먹었으면 증가하고 먹은 갯수 초기화
			ate = 0;
			mySize++;
		}
		myPoint.r = np.r;
		myPoint.c = np.c;
	}
}
