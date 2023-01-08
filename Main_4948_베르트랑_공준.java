package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 12,128kb
// 720ms

public class Main_4948_베르트랑_공준 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			int cnt = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (isPrime(i))
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}
}