package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// 11,704kb
// 80ms

public class Main_1302_베스트셀러 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		int bestCnt = 0;
		String bestSeller = "";
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int cnt = map.getOrDefault(str, 0) + 1;
			map.put(str, cnt);
			if (cnt > bestCnt) {
				bestCnt = cnt;
				bestSeller = str;
			} else if (cnt == bestCnt && str.compareTo(bestSeller) < 0) {
				bestCnt = cnt;
				bestSeller = str;
			}
		}

		bw.write(bestSeller);
		bw.flush();
		bw.close();
	}
}