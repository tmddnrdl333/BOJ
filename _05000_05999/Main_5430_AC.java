package ps.BOJ._05000_05999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

// 131,872kb
// 920ms

public class Main_5430_AC {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static Deque<Integer> dq;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {

			char[] command = br.readLine().toCharArray();
			int len = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			arr = arr.substring(1, arr.length() - 1);
			StringTokenizer st = new StringTokenizer(arr, ",");
			dq = new ArrayDeque<>();
			for (int i = 0; i < len; i++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}

			boolean forward = true;
			try {
				for (char c : command) {
					if (c == 'R')
						forward = !forward;
					else if (forward)
						dq.removeFirst();
					else
						dq.removeLast();
				}
				if (forward) {
					sb.append(dq.toString().replace(" ", ""));
				} else {
					Iterator<Integer> it = dq.descendingIterator();
					sb.append("[");
					if (!it.hasNext())
						sb.append(" "); // 개어이없음 
					while (it.hasNext()) {
						sb.append(it.next() + ",");
						it.remove();
					}
					if (sb.length() > 2)
						sb.setLength(sb.length() - 1);
					sb.append("]");
				}
			} catch (Exception e) {
				sb.append("error");
			}
			sb.append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}