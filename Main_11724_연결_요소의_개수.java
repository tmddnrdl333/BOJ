package study.day0307;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 114,796kb
// 452ms

public class Main_11724_연결_요소의_개수 {
	static int[] parents;

	// 초기 설정
	public static void makeSet() {
		parents = new int[N];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 0; i < N; i++)
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

	static int N, M;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		makeSet();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			union(a, b);
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(findSet(i));
		}
		bw.write(Integer.toString(set.size()));
		bw.flush();
		bw.close();
	}
}