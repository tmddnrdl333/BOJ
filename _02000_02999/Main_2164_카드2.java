package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 43,196kb
// 144ms

public class Main_2164_카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			q.add(i);

		while (q.size() != 1) {
			q.poll();
			q.add(q.poll());
		}

		bw.write(q.poll() + "");
		bw.flush();
		bw.close();
	}
}