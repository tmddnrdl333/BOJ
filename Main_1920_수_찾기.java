package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 60,632kb
// 528ms

public class Main_1920_수_찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(Integer.parseInt(st.nextToken()));
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (set.contains(Integer.parseInt(st.nextToken())))
				sb.append(1);
			else
				sb.append(0);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}