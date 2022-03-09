package study.day0308;

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

// 19,688kb
// 696ms

public class Main_14466_소가_길을_건너간_이유_6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K, R;
	static int[][] map;
	static int[][] road; // 길 정보 ( r1 c1 r2 c2 )
	static int[][] cow; // 소 위치 ( r c )

	static List<Integer> group = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		road = new int[R][4];
		cow = new int[K][2];
		// 길 정보 저장
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++)
				road[i][j] = Integer.parseInt(st.nextToken()) - 1;
		}
		// 소 정보 저장
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cow[i][0] = Integer.parseInt(st.nextToken()) - 1;
			cow[i][1] = Integer.parseInt(st.nextToken()) - 1;
			map[cow[i][0]][cow[i][1]] = 1;
		}
		// 각 소에 대해 다른 소로 갈 수 있는지 확인
		// A소가 B소는 갈 수 있는데 C소를 못간다면
		// 어차피 B소도 C소로 갈 수 없음
		// 즉, A B는 한 집합에 있다고 볼 수 있고 C는 다른 집합이라고 봐야함.
		// 즉 A가 B를 갈 수 있다면 B는 볼 필요 없다는 뜻 (어차피 A가 갈 수 있으면 다가고 못가면 다 못감)
		for (int i = 0; i < K; i++) {
			// 아직 안 본 소만 보자
			if (map[cow[i][0]][cow[i][1]] != 1)
				continue;
			// 안 본 소다 -> BFS
			map[cow[i][0]][cow[i][1]] += 10;
			int cowCnt = 1; // 현재 그룹의 소 마릿수 카운팅
			Queue<int[]> q = new LinkedList<>();
			q.add(cow[i]);
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int[] up = up(cur);
				if (up != null) { // 위로 갈 수 있다면
					if (map[up[0]][up[1]] < 2) { // 미방문 땅(0) 혹은 소 (1)이면 10 더하기
						if (map[up[0]][up[1]] == 1)
							cowCnt++; // 소면 하나 세기
						map[up[0]][up[1]] += 10;
						q.add(up);
					}
				}
				int[] down = down(cur);
				if (down != null) { // 위로 갈 수 있다면
					if (map[down[0]][down[1]] < 2) { // 미방문 땅(0) 혹은 소 (1)이면 10 더하기
						if (map[down[0]][down[1]] == 1)
							cowCnt++; // 소면 하나 세기
						map[down[0]][down[1]] += 10;
						q.add(down);
					}
				}
				int[] left = left(cur);
				if (left != null) { // 위로 갈 수 있다면
					if (map[left[0]][left[1]] < 2) { // 미방문 땅(0) 혹은 소 (1)이면 10 더하기
						if (map[left[0]][left[1]] == 1)
							cowCnt++; // 소면 하나 세기
						map[left[0]][left[1]] += 10;
						q.add(left);
					}
				}
				int[] right = right(cur);
				if (right != null) { // 위로 갈 수 있다면
					if (map[right[0]][right[1]] < 2) { // 미방문 땅(0) 혹은 소 (1)이면 10 더하기
						if (map[right[0]][right[1]] == 1)
							cowCnt++; // 소면 하나 세기
						map[right[0]][right[1]] += 10;
						q.add(right);
					}
				}
			}
//			for (int k = 0; k < 4; k++)
//				System.out.println(Arrays.toString(map[k]));
//			System.out.println();

			group.add(cowCnt);
		}
//		System.out.println("\n" + group);
		int res = 0;
		int gCnt = group.size();
		for (int i = 0; i < gCnt - 1; i++) {
			for (int j = i + 1; j < gCnt; j++) {
				res += group.get(i) * group.get(j);
			}
		}
		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();
	}

	// up down left right
	// 길이 아니고 장외 아니면 r c 좌표의 크기 2 배열 반환
	// 못갈 시 null 반환

	public static int[] up(int[] rc) {
		int[] nrc = { rc[0] - 1, rc[1] };
		if (rc[0] == 0) // 나가는 경우
			return null;
		for (int[] r : road) // 길인 경우
			if (rc[0] == r[0] && rc[1] == r[1] && nrc[0] == r[2] && nrc[1] == r[3]
					|| rc[0] == r[2] && rc[1] == r[3] && nrc[0] == r[0] && nrc[1] == r[1])
				return null;
		return nrc;
	}

	public static int[] down(int[] rc) {
		int[] nrc = { rc[0] + 1, rc[1] };
		if (rc[0] == N - 1) // 나가는 경우
			return null;
		for (int[] r : road) // 길인 경우
			if (rc[0] == r[0] && rc[1] == r[1] && nrc[0] == r[2] && nrc[1] == r[3]
					|| rc[0] == r[2] && rc[1] == r[3] && nrc[0] == r[0] && nrc[1] == r[1])
				return null;
		return nrc;
	}

	public static int[] left(int[] rc) {
		int[] nrc = { rc[0], rc[1] - 1 };
		if (rc[1] == 0) // 나가는 경우
			return null;
		for (int[] r : road) // 길인 경우
			if (rc[0] == r[0] && rc[1] == r[1] && nrc[0] == r[2] && nrc[1] == r[3]
					|| rc[0] == r[2] && rc[1] == r[3] && nrc[0] == r[0] && nrc[1] == r[1])
				return null;
		return nrc;
	}

	public static int[] right(int[] rc) {
		int[] nrc = { rc[0], rc[1] + 1 };
		if (rc[1] == N - 1) // 나가는 경우
			return null;
		for (int[] r : road) // 길인 경우
			if (rc[0] == r[0] && rc[1] == r[1] && nrc[0] == r[2] && nrc[1] == r[3]
					|| rc[0] == r[2] && rc[1] == r[3] && nrc[0] == r[0] && nrc[1] == r[1])
				return null;
		return nrc;
	}

}