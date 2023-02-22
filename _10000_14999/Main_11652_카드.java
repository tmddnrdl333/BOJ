package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// 33,792kb
// 300ms

public class Main_11652_카드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new HashMap<>();
		long res = -((long) 1 << 62) - 1;
		int maxCnt = 0;
		for (; N > 0; N--) {
			long num = Long.parseLong(br.readLine());
			int cnt = map.getOrDefault(num, 0);
			map.put(num, ++cnt);
			if (cnt > maxCnt) {
				maxCnt = cnt;
				res = num;
			} else if (cnt == maxCnt && num < res) {
				res = num;
			}
		}
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}