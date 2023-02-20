package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 49,120kb
// 664ms

public class Main_15323_ZigZag {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int K, N;
	static Map<Character, List<String>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			String str = br.readLine();
			char c = str.charAt(0);
			if (!map.containsKey(c)) {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(c, list);
			} else {
				List<String> list = map.get(c);
				list.add(str);
				map.put(c, list);
			}
		}
		for (char c : map.keySet()) {
			List<String> list = map.get(c);
			list.sort((o1, o2) -> o1.compareTo(o2));
		}
		int[] arr = new int[26];
		for (int i = 0; i < N; i++) {
			char c = br.readLine().charAt(0);
			sb.append(map.get(c).get(arr[c - 'a'])).append("\n");
			arr[c - 'a'] = (arr[c - 'a'] + 1) % map.get(c).size();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}