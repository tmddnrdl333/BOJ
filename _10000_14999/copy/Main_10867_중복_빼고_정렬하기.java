package ps.BOJ._10000_14999.copy;

import java.io.*;
import java.util.*;

// 22,360kb
// 220ms

public class Main_10867_중복_빼고_정렬하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[2001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[tmp + 1000] = 1;
		}
		for (int i = 0; i < 2001; i++) {
			if (arr[i] == 1)
				sb.append((i - 1000) + " ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
