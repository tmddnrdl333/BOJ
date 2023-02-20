package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 18,932kb
// 188ms

public class Main_10845_큐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			switch (type.charAt(0)) {
			case 'p':
				if (type.charAt(1) == 'u') {
					q.add(Integer.parseInt(st.nextToken()));
				} else {
					sb.append(!q.isEmpty() ? q.poll() : -1).append("\n");
				}
				break;
			case 's':
				sb.append(q.size()).append("\n");
				break;
			case 'e':
				sb.append(q.isEmpty() ? 1 : 0).append("\n");
				break;
			case 'f':
				sb.append(!q.isEmpty() ? q.peek() : -1).append("\n");
				break;
			case 'b':
				sb.append(!q.isEmpty() ? q.get(q.size() - 1) : -1).append("\n");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}