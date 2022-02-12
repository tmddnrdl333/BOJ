package boj0212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12228kb
// 92ms

public class Main_9934_완전이진트리 {
	static int[] arr;
	static int K, len;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		len = (int) Math.pow(2, K);
		arr = new int[len];
		for (int i = 1; i < len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		fill(len, 1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void fill(int lastIdx, int cnt) {
		int pick = lastIdx / 2;
		int pickCnt = (int) Math.pow(2, cnt) - 1;
		for (int i = 1; i <= pickCnt; i++) {
			if (arr[pick * i] != 0) {
				sb.append(arr[pick * i] + " ");
				arr[pick * i] = 0;
			}
		}
		if (lastIdx == 1)
			return;
		sb.append("\n");
		fill(lastIdx / 2, cnt + 1);
	}
}
