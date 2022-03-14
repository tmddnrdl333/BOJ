package study.day0310;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 42,608kb
// 296ms

public class Main_17471_게리맨더링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N;
	static int[] population;
	static boolean[][] adjM;

	static int popSum = 0;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			population[i] = temp;
			popSum += temp;
		}
		// 인접행렬 생성
		adjM = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				adjM[i][to] = true;
			}
		}

		// 1로 시작하는 DFS
		DFS(0, 0, 0);
		if (res == Integer.MAX_VALUE)
			res = -1;
		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();
	}

	public static void DFS(int v, int visited, int canvisit) {
		visited |= 1 << v;
		for (int j = 0; j < N; j++)
			canvisit = adjM[v][j] ? canvisit | 1 << j : canvisit;

		// 나머지 전부가 연결 돼있는지 확인.
		// 연결돼있다면 인구수 합해서 비교
		int curUnv = isConnected(visited);
		if (curUnv != -1) {
			int curGap = Math.abs(popSum - 2 * curUnv);
			res = curGap < res ? curGap : res;
		}
		for (int i = 0; i < N; i++)
			if ((visited & 1 << i) == 0 && (canvisit & 1 << i) != 0)
				DFS(i, visited | 1 << i, canvisit);
	}

	public static int isConnected(int visited) {
		int start = -1;
		for (int i = 0; i < N; i++)
			if ((visited & 1 << i) == 0) {
				start = i;
				break;
			}
		if (start == -1)
			return -1;
		int unvisited = 1 << start;
		int unvSum = population[start];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < N; i++)
				if (adjM[cur][i] && (visited & 1 << i) == 0 && (unvisited & 1 << i) == 0) {
					q.add(i);
					unvSum += population[i];
					unvisited |= 1 << i;
				}
		}
		if (visited + unvisited != (1 << N) - 1)
			return -1;
		return unvSum;
	}
}