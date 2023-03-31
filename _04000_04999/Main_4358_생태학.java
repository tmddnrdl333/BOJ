package ps.BOJ._04000_04999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 89,620kb
// 580ms

public class Main_4358_생태학 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Map<String, Integer> map = new HashMap<>();
		int cnt = 0;

		String tree = br.readLine();

		while (true) {
			map.put(tree, map.getOrDefault(tree, 0) + 1);
			cnt++;

			tree = br.readLine();
			if (tree == null || tree.isEmpty())
				break;

		}

		Object[] keys = map.keySet().toArray();

		Arrays.sort(keys);

		for (Object key : keys) {
			sb.append(key + " " + String.format("%.4f", (double) map.get(key) / cnt * 100)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}