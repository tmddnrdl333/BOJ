package ps.BOJ._20000_29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 37,244kb
// 300ms

public class Main_21736_헌내기는_친구가_필요해 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Pnt {
		int r, c;

		Pnt(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		int sr = 0, sc = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 'I') {
					sr = i;
					sc = j;
				}

		int cnt = 0;

		Queue<Pnt> q = new LinkedList<>();
		q.add(new Pnt(sr, sc));
		map[sr][sc] = 'o';

		while (!q.isEmpty()) {
			Pnt cp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cp.r + dr[d], nc = cp.c + dc[d];
				if (nr == -1 || nr == N || nc == -1 || nc == M)
					continue;
				if (map[nr][nc] == 'o' || map[nr][nc] == 'X')
					continue;
				if (map[nr][nc] == 'P')
					cnt++;
				q.add(new Pnt(nr, nc));
				map[nr][nc] = 'o';
			}
		}

		if (cnt == 0)
			bw.write("TT");
		else
			bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}