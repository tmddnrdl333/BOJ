package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,556kb
// 92ms

public class Main_4672_셀프_넘버 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		boolean[] arr = new boolean[10001];

		for (int i = 1; i <= 9992; i++) {
			if (arr[i])
				continue;
			int num = next(i);
			while (num != -1) {
				if (!arr[num])
					arr[num] = true;
				num = next(num);
			}
		}

		for (int i = 1; i <= 10000; i++) {
			if (!arr[i])
				sb.append(i).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	static int next(int n) {
		int d = 10000;
		while (n / d < 1)
			d /= 10;
		int ret = n;
		while (d > 0) {
			ret += n / d;
			n -= n / d * d;
			d /= 10;
		}
		if (ret > 10000)
			return -1;
		return ret;
	}
}