package ps.BOJ._20000_29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 246,844kb
// 1,128ms

public class Main_22233_가희와_키워드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> memo = new HashSet<>();
		for (int i = 0; i < N; i++)
			memo.add(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while (st.hasMoreTokens()) {
				String keyword = st.nextToken();

				if (memo.contains(keyword)) {
					memo.remove(keyword);
				}
			}
			sb.append(memo.size()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}