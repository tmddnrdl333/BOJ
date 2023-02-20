package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 25,608kb
// 288ms

public class Main_1927_최소_힙 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (; N > 0; N--) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (pq.isEmpty())
					sb.append("0\n");
				else
					sb.append(pq.poll()).append("\n");
			} else {
				pq.add(input);
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}