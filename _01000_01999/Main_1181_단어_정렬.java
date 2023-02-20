package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 32,632kb
// 404ms

public class Main_1181_단어_정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		String[] strs = new String[N];
		for (int i = 0; i < N; i++)
			strs[i] = br.readLine();
		Arrays.sort(strs, (o1, o2) -> (o1.length() != o2.length() ? o1.length() - o2.length() : o1.compareTo(o2)));
		String tmp = "";
		for (int i = 0; i < N; i++) {
			if (strs[i].equals(tmp))
				continue;
			sb.append(strs[i]).append("\n");
			tmp = strs[i];
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}