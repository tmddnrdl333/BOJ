package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 12,908kb
// 92ms

public class Main_2469_사다리_타기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int k, n;
	static char[] res, now;

	static char[][] ladder;
	static int q; // ?가 있는 위치

	public static void main(String[] args) throws IOException {
		k = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		res = br.readLine().toCharArray();
		now = new char[k];
		for (int i = 0; i < k; i++)
			now[i] = (char) ('A' + i);
		ladder = new char[n][k - 1];
		for (int i = 0; i < n; i++) {
			ladder[i] = br.readLine().toCharArray();
			if (ladder[i][0] == '?')
				q = i;
		}

		for (int i = 0; i < q; i++)
			downward(i);
		for (int i = n - 1; i > q; i--)
			upward(i);

		for (int i = 0; i < k - 1; i++) {
			if (now[i] == res[i]) {
				sb.append("*");
			} else if (now[i] == res[i + 1] && now[i + 1] == res[i]) {
				sb.append("-*");
				i++;
			} else {
				sb.setLength(0);
				for (int j = 0; j < k - 1; j++)
					sb.append("x");
				break;
			}
		}
		sb.setLength(k - 1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	// step번째 ladder를 보고 now를 바꿔주는 함수
	public static void downward(int step) {
		for (int i = 0; i < k - 1; i++) {
			if (ladder[step][i] == '-') {
				char temp = now[i];
				now[i] = now[i + 1];
				now[i + 1] = temp;
				i++;
			}
		}
	}

	public static void upward(int step) {
		for (int i = 0; i < k - 1; i++) {
			if (ladder[step][i] == '-') {
				char temp = res[i];
				res[i] = res[i + 1];
				res[i + 1] = temp;
				i++;
			}
		}
	}
}