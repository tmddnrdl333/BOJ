package study.day0315;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 11,716kb
// 84ms

public class Main_1043_거짓말 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N, M;
	static int[][] party;
	static boolean[] flag;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++)
			set.add(Integer.parseInt(st.nextToken()) - 1); // 아는 사람들의 인덱스
		party = new int[M][];
		flag = new boolean[M]; // 불가능해지면 true
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			party[i] = new int[size];
			for (int j = 0; j < size; j++)
				party[i][j] = Integer.parseInt(st.nextToken()) - 1; // 이번 파티 참여 사람 인덱스
		}
		boolean w = true; // 다시 돌 필요 있는지?
		while (w) {
			w = false;
			for (int i = 0; i < M; i++) {
				if (flag[i])
					continue;
				boolean contain = false; // set에 추가할지?
				for (int idx : party[i])
					if (set.contains(idx)) {
						contain = true;
						flag[i] = true;
						w = true;
						break;
					}
				if (contain) {
					for (int idx : party[i])
						set.add(idx);
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < M; i++)
			if (!flag[i])
				cnt++;
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();

	}
}