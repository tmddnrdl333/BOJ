package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 40,956kb
// 1284ms

public class Main_1774_우주신과의_교감 {
	// ## kruskal
	static class Edge implements Comparable<Edge> {
		int from, to;
		double distance;

		public Edge(int from, int to, double distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.distance > o.distance)
				return 1;
			else if (this.distance == o.distance)
				return 0;
			else
				return -1;
		}
	}

	static Edge[] edgeList;
	// ## kruskal

	// ## union-find
//	static int N;
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
	// ## union-find

	// 점
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	// 입출력
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	//
	static int N, M;
	static Point[] points;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 총 정점 수
		M = Integer.parseInt(st.nextToken()); // 연결된 정점쌍 수
		points = new Point[N]; // 정점객체 배열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y); // 정점 위치 입력&생성
		}

		// 간선 리스트 생성
		edgeList = new Edge[N * (N - 1) / 2]; // 간선 총 개수
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				edgeList[cnt++] = new Edge(i, j, dist(points[i], points[j]));

		// 이미 연결된 것들 입력받고 반영
		// 이미 연결된 것을 비용 0으로 해주면 자동으로 먼저 선택되면서 연결됨
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			// 연결시켜주셈
			int smaller = Math.min(from, to);
			int gap = Math.max(from, to) - smaller;
			int index = 0, n = N - 1;
			for (; smaller != 0; smaller--)
				index += n--;
			index += gap - 1;
			edgeList[index].distance = 0;
		}

		// 비용기준 오름차순 정렬
		Arrays.sort(edgeList);
		makeSet();

		// kruskal
		double result = 0;
		cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.distance;
				if (++cnt == N - 1)
					break;
			}
		}
		System.out.printf("%.2f", result);

	}

	// 거리 계산 함수
	public static double dist(Point a, Point b) {
		return Math.sqrt((double) (Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2)));
	}

}