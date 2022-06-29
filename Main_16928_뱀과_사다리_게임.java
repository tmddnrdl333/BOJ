package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 11796kb
// 80ms

public class Main_16928_뱀과_사다리_게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[][] map = new int[101][2];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 101; i++)
			map[i][0] = i;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][0] = to;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][0] = to;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int time = 0;

		outer: while (!q.isEmpty()) {
			int size = q.size();
			time++;
			for (; size != 0; size--) {
				int cur = q.poll();
				int max = cur;
				for (int dice = 6; dice >= 1; dice--) {
					if (cur + dice >= 100)
						break outer;
					if (map[cur + dice][1] != 0)
						continue;
					int temp = map[cur + dice][0];
					map[cur + dice][1] = time;
					q.add(temp);
				}
			}
		}

		System.out.println(time);

	}
}