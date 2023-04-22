package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 170,264kb
// 860ms

public class Main_18917_수열과_쿼리_38 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		long sum = 0;
		long xor = 0;

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1:
				int num1 = Integer.parseInt(st.nextToken());
				sum += num1;
				xor ^= num1;
				break;
			case 2:
				int num2 = Integer.parseInt(st.nextToken());
				sum -= num2;
				xor ^= num2;
				break;
			case 3:
				sb.append(sum + "\n");
				break;
			case 4:
				sb.append(xor + "\n");
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}