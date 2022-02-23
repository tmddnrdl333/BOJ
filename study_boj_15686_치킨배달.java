package study.day0222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 14,056kb
// 156ms

public class study_boj_15686_치킨배달 {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public int dist(Point p) {
			return Math.abs(r - p.r) + Math.abs(c - p.c);
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;

	static List<Point> house = new ArrayList<>();
	static List<Point> chick = new ArrayList<>();

	static int[] pick;
	static int len;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 0)
					continue;
				else if (now == 1)
					house.add(new Point(i, j));
				else if (now == 2)
					chick.add(new Point(i, j));
			}
		}

		len = chick.size();
		pick = new int[len];
		for (int i = len - 1; i > len - 1 - M; i--) {
			pick[i] = 1;
		}

		int min = Integer.MAX_VALUE;
		do {
			int res = 0;
			// pick에 대하여 거리 계산
			for (Point p : house) {
				res += shortest(p);
			}
			min = res < min ? res : min;
		} while (np());

		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}

	public static boolean np() {
		// 1. 교환 위치 찾기
		int i = len - 1;
		while (i > 0 && pick[i - 1] >= pick[i])
			--i;
		if (i == 0)
			return false; // 완성된 상황

		// 2. 교환 위치에 교환할 값 찾기
		int j = len - 1;
		while (pick[i - 1] >= pick[j])
			--j;

		// 3. 교환 위치와 교환할 값 교환하기
		swap(i - 1, j);

		// 4. 교환 위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순 정렬)
		int k = len - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	public static void swap(int i, int j) {
		int temp = pick[i];
		pick[i] = pick[j];
		pick[j] = temp;
	}

	public static int shortest(Point p) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if (pick[i] == 1) {
				int temp = p.dist(chick.get(i));
				min = temp < min ? temp : min;
			}
		}
		return min;
	}

}
