package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 298,480kb
// 3,100ms

public class Main_9109_DSLR {

	static class Num {
		int n;
		String s;

		Num(int n, String s) {
			this.n = n;
			this.s = s;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder resSb = new StringBuilder();

	static int from, to;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[10000];

			Queue<Num> q = new LinkedList<>();
			q.add(new Num(from, ""));
			while (!q.isEmpty()) {
				Num cNum = q.poll();
				int cN = cNum.n;
				String cS = cNum.s;

				if (cN == to) {
					resSb.append(cS).append("\n");
					break;
				}

				if (!visited[D(cN)]) {
					visited[D(cN)] = true;
					q.add(new Num(D(cN), cS + "D"));
				}
				if (!visited[S(cN)]) {
					visited[S(cN)] = true;
					q.add(new Num(S(cN), cS + "S"));
				}
				if (!visited[L(cN)]) {
					visited[L(cN)] = true;
					q.add(new Num(L(cN), cS + "L"));
				}
				if (!visited[R(cN)]) {
					visited[R(cN)] = true;
					q.add(new Num(R(cN), cS + "R"));
				}
			}

		}

		bw.write(resSb.toString());
		bw.flush();
		bw.close();
	}

	public static int D(int num) {
		return num * 2 % 10000;
	}

	public static int S(int num) {
		return num == 0 ? 9999 : num - 1;
	}

	public static int L(int num) {
		return num * 10 % 10000 + num / 1000;
	}

	public static int R(int num) {
		return num / 10 + num % 10 * 1000;
	}

}