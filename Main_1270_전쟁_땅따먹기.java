package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// memory초과

public class Main_1270_전쟁_땅따먹기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			map = new HashMap<>();
			for (int j = 0; j < T; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if (!map.containsKey(cur)) {
					map.put(cur, 1);
				} else {
					map.replace(cur, map.get(cur) + 1);
				}
			}
			//
			boolean can = false;
			for (int key : map.keySet()) {
				if (map.get(key) > T / 2) {
					sb.append(key).append("\n");
					can = true;
					break;
				}
			}
			if (!can)
				sb.append("SYJKGW\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
