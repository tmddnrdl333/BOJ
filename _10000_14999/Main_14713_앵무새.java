package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 23,272kb
// 264ms

public class Main_14713_앵무새 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		@SuppressWarnings("unchecked")
		Queue<String>[] q = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			q[i] = new LinkedList<>();
			while (st.hasMoreTokens())
				q[i].add(st.nextToken());
		}

		// false: 가능, true: 불가능
		boolean outerFlag = false;
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			// false: 불가능, true: 가능
			boolean innerFlag = false;
			for (int i = 0; i < N; i++) {
				if (token.equals(q[i].peek())) {
					q[i].poll();
					innerFlag = true;
					break;
				}
			}
			if (!innerFlag) {
				outerFlag = true;
				break;
			}
		}

		for (int i = 0; i < N; i++)
			if (!q[i].isEmpty()) {
				outerFlag = true;
				break;
			}

		if (outerFlag)
			bw.write("Impossible");
		else
			bw.write("Possible");
		bw.flush();
		bw.close();
	}
}