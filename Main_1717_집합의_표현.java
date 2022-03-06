package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 48,420kb
// 408ms

public class Main_1717_집합의_표현 {

	static int[] parents;

	// 초기 설정
	public static void makeSet() {
		parents = new int[n + 1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 0; i < n + 1; i++)
			parents[i] = i;
	}

	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]); // path compression
	}

	// a, b 두 집합 합치기 (a를 b밑에 넣기)
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		// a밑에 b를 넣기 (b짱의 부모를 a짱으로 설정)
		parents[bRoot] = aRoot;
		return true;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		makeSet();

		int i1 = 0, i2 = 0, i3 = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			i1 = Integer.parseInt(st.nextToken());
			i2 = Integer.parseInt(st.nextToken());
			i3 = Integer.parseInt(st.nextToken());
			if (i1 == 0) {
				union(i2, i3);
			} else {
				if (findSet(i2) == findSet(i3)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}