package study.day0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 12,348kb
// 92ms

public class study_boj_1566_N과M12 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static StringBuilder sb = new StringBuilder();

	static int M, len;
	static Integer[] arr;
	static int[] output;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		arr = set.toArray(new Integer[0]);
		Arrays.sort(arr);
		len = arr.length;
		// 입력 끝

		// 결과를 저장할 배열 생성
		output = new int[M];

		// arr를 중복 허용하여 순열로 생성 (사전순)
		permuR(0, 0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	public static void permuR(int cnt, int start) {

		if (cnt == M) {
			for (int i = 0; i < M; i++)
				sb.append(output[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = start; i < len; i++) {
			output[cnt] = arr[i];
			permuR(cnt + 1, i);
		}
	}
}
