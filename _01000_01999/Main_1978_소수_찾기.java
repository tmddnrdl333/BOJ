package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,668kb
// 76ms

public class Main_1978_소수_찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int cnt;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			count(Integer.parseInt(st.nextToken()));
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}

	static void count(int n) {
		if (n == 1)
			return;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return;
		}
		cnt++;
	}
}