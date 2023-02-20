package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 296,864kb
// 820ms

public class Main_16234_인구_이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, L, R;
	static int[][] populationMap;
	static int[][] devidedMap;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		populationMap = new int[N][N];
		devidedMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				populationMap[i][j] = Integer.parseInt(st.nextToken());
		}

		//
		int day = 0;
		while (oneday()) {
			day++;
//			print();
			clear();
		}

		System.out.println(day);
	}

//	public static void print() {
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(devidedMap[i]));
//		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(populationMap[i]));
//		}
//	}

	public static boolean oneday() {

		boolean flag = false;

		int number = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				if (devidedMap[i][j] != 0)
					continue;
				number++;
				int count = 1;
				int totalPopulation = populationMap[i][j];
				Queue<int[]> q = new LinkedList<>();
				List<int[]> list = new ArrayList<>();
				devidedMap[i][j] = number;
				q.add(new int[] { i, j });
				list.add(new int[] { i, j });

				while (!q.isEmpty()) {
					int[] cur = q.poll();
					int curV = populationMap[cur[0]][cur[1]];
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
						if (nr == -1 || nc == -1 || nr == N || nc == N)
							continue;
						if (devidedMap[nr][nc] != 0)
							continue;
						int nV = populationMap[nr][nc];
						int gap = Math.abs(curV - nV);
						if (gap >= L && gap <= R) {
							devidedMap[nr][nc] = number;
							count++;
							totalPopulation += populationMap[nr][nc];
							q.add(new int[] { nr, nc });
							list.add(new int[] { nr, nc });
						}
					}
				}
				if (count == 1)
					continue;
				flag = true;
				int devidedPopulation = totalPopulation / count;
				for (int[] arr : list) {
					populationMap[arr[0]][arr[1]] = devidedPopulation;
				}
			}
		return flag;
	}

	public static void clear() {
		for (int i = 0; i < N; i++) {
			devidedMap[i] = new int[N];
		}
	}

}