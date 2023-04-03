package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 32,052kb
// 308ms

public class Main_2015_수들의_합_4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] sum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

		long cnt = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 1; i <= N; i++) {
			cnt += (long) map.getOrDefault(sum[i] - K, 0);
			map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}