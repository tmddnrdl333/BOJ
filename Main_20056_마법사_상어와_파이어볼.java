package study.day0419;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 61,780kb
// 484ms

public class Main_20056_마법사_상어와_파이어볼 {

	static class Fire {
		int r, c, m, s, d, cnt;

		public Fire(int r, int c, int m, int s, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.cnt = cnt;
		}
	}

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M, K;
	static List<Fire> fireList;
	static Map<Integer, Fire> fireMap;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fireList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1, c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireList.add(new Fire(r, c, m, s, d, 1));
		}

		// K번 명령
		int time = 0;
		while (true) {
//			System.out.println("====" + time + "====");
			// fireList의 Fire를 속도와 방향으로 이동하여 fireMap에 저장(누적)
			fireMap = new HashMap<>();
			for (Fire fire : fireList) {
				int r = fire.r, c = fire.c;
				int m = fire.m, s = fire.s, d = fire.d;
				int modS = s % N;
				int nr = r + modS * dr[d], nc = c + modS * dc[d];
				nr = (nr + N) % N;
				nc = (nc + N) % N;
				int nIdx = nr * N + nc;
				if (fireMap.containsKey(nIdx)) {
					// fire 누적
					Fire nf = fireMap.get(nIdx);
					int nd = 0;
					if (nf.d >= 0) {
						if (nf.d % 2 != 0 && d % 2 != 0)
							nd = -1;
						else if (nf.d % 2 == 0 && d % 2 == 0)
							nd = -2;
						else
							nd = -3;
					} else {
						if (nf.d == -1 && d % 2 != 0)
							nd = -1;
						else if (nf.d == -2 && d % 2 == 0)
							nd = -2;
						else
							nd = -3;
					}
//					System.out.println("# (1) " + nr + " " + nc + " " + (nf.m + m) + " " + (nf.s + s) + " " + nd + " "
//							+ (nf.cnt + 1));
					fireMap.put(nIdx, new Fire(nr, nc, nf.m + m, nf.s + s, nd, nf.cnt + 1));
				} else {
					// 새 fire put
//					System.out.println("# (2) " + nr + " " + nc + " " + m + " " + s + " " + d + " " + 1);
					fireMap.put(nIdx, new Fire(nr, nc, m, s, d, 1));
				}
			}
			//

			// fireMap있는 Fire들을 찢어서 다시 fireList에 넣음
			fireList.clear();
			for (int idx : fireMap.keySet()) {
				Fire fire = fireMap.get(idx);
				if (fire.cnt == 1) {
//					System.out.println("@-(3) " + idx / N + " " + idx % N + " " + fire.m + " " + fire.s + " " + fire.d);
					fireList.add(new Fire(idx / N, idx % N, fire.m, fire.s, fire.d, fire.cnt));
					continue;
				}
				int nm = fire.m / 5;
				if (nm == 0)
					continue;
				int ns = fire.s / fire.cnt;
				int diff = fire.d;
				if (diff == -3)
					diff = 1;
				else
					diff = 0;
				for (int nd = 0 + diff; nd < 8; nd += 2) {
//					System.out.println("@-(4) " + idx / N + " " + idx % N + " " + nm + " " + ns + " " + nd);
					fireList.add(new Fire(idx / N, idx % N, nm, ns, nd, 1));
				}
			}
			//

			if (++time == K)
				break;
		}

		int sum = 0;
		for (Fire fire : fireList) {
			sum += fire.m;
//			System.out.println("### " + fire.m + " ( " + fire.r + " " + fire.c + " )");
		}

		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
	}
}