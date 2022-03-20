package study.day0317;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 15,288kb
// 116ms

public class Main_16953_A_B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static long A, B;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		Queue<Long> q = new LinkedList<>();
		q.add(A);
		int cnt = 0;
		boolean flag = false;
		w: while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (; size != 0; size--) {
				long cur = q.poll();
				if (cur == B) {
					flag = true;
					break w;
				}
				if (cur * 2 <= B)
					q.add(cur * 2);
				if (cur * 10 + 1 <= B)
					q.add(cur * 10 + 1);
			}
		}
		if (!flag)
			cnt = -1;
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}
}