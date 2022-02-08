package study.day0208;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class study_boj_3190 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 크기
		int K = sc.nextInt(); // 사과 수
		// 맵 만들고 사과 찍기
		int[][] map = new int[N][N];
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r - 1][c - 1] = 1;
		}
		// 조작 로그 받기
		int L = sc.nextInt();
		Queue<Integer> shiftS = new LinkedList<>();
		Queue<Character> shiftD = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			shiftS.offer(sc.nextInt());
			shiftD.offer(sc.next().charAt(0));
		}
		sc.close();
		// 입력 끝
		// =============맵 확인용============
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		// =========================
		//
		// == 시작
		// 시간
		int t = 0;
		// 현위치
		int r = 0;
		int c = 0;
		// 몸 길이
		int len = 1;
		// 방향
		int dir = 0;
		// - 0 오른쪽 시작, +1하면 우로 90도
		int[][] plus = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		// 몸 겹치는지 확인용
		Queue<int[]> q = new LinkedList<>();
		// 시작위치 몸 넣기
		q.offer(new int[] { 0, 0 });

		g: while (true) {
			// ==== 1초 후 상황이 가능한지? ====
			t++;

			// 다음 칸에 몸을 밀어 넣는다면?
			int nr = r + plus[dir][0];
			int nc = c + plus[dir][1];
			// 벽 만날 시 끝남
			if (nr == N || nr == -1 || nc == N || nc == -1) {
//				System.out.println("GAME OVER 벽박치기"); //
				break g;
			}
			// 몸 만날 시 끝남
			for (int[] i : q) {
				// q에 있는 두칸짜리 i는 몸이 있는 칸들의 모임
				if (nr == i[0] && nc == i[1]) {
//					System.out.println("GAME OVER 몸통박치기");
					break g;
				}
			}
			// ==== 불가능한 상황 제외하면 아래로 이동 ====

			// ==== 가능하니까 이동 ====
			r = nr;
			c = nc;
			q.offer(new int[] { r, c });
//			System.out.println("t=" + t + " [" + r + "," + c + "]");
			// 머리만 늘어난 몸 출력해보기
//			for (int[] i : q) {
//				System.out.println(i[0] + " " + i[1]);
//			}
			// 사과 있는지 체크
			if (map[r][c] == 1) {
				map[r][c] = 0;
				len++;
			}
			// 꼬리 자르기 (목만 길어진 상태니까 +1)
			if (q.size() == len + 1)
				q.poll();

			// 방향 바꿔놓기(다음 루프에 적용할)
			if (!shiftS.isEmpty())
				if (shiftS.peek() == t) {
					shiftS.poll();
					if (shiftD.poll() == 'D') {
						dir = (dir + 1) % 4;
					} else {
						dir = (dir + 3) % 4;
					}
				}

		} // while

		// 결과
		System.out.println(t);
	}
}
