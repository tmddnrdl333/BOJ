package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 21,408kb
// 184ms

public class Main_1644_소수의_연속합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int pSize = N / 8 + 1;
		byte[] p = new byte[pSize]; // 0이면 소수고, 1이면 소수가 아님
		p[0] = 3; // 0과 1은 소수가 아님
		int max = (int) Math.sqrt(N);
		for (int i = 2; i <= max; i++) {
			if ((p[i >>> 3] & 1 << (i & 7)) != 0)
				continue;
			int cur = i + i; // 2배부터 소거
			while (cur <= N) {
				p[cur >>> 3] |= 1 << (cur & 7);
				cur += i;
			}
		}
		List<Integer> primes = new ArrayList<>();
		for (int i = 0; i < pSize; i++) {
			for (int j = 0; j < 8; j++) {
				int cur = (i << 3) + j;
				if (cur > N)
					break;
				if ((p[i] & 1 << j) == 0) {
					primes.add(cur);
				}
			}
		}
//		System.out.println(primes); // test

		if (N < 3) { // 1이면 0, 2이면 1이니까.
			System.out.println(N - 1);
			return;
		}

		int primeSize = primes.size();
		int s = 0, e = 0, sum = primes.get(0);
		int cnt = 0;
		if (primes.get(primeSize - 1) == N)
			cnt++;
		while (true) {
//			System.out.println(sum);
//			System.out.print(" : ");
//			for (int i = s; i <= e; i++) {
//				System.out.print(primes.get(i) + " ");
//			}
//			System.out.println();
			if (sum == N) {
				cnt++;
				sum += primes.get(++e);
				sum -= primes.get(s++);
			} else if (sum < N) {
				sum += primes.get(++e);
			} else {
				sum -= primes.get(s++);
			}
			if (primes.get(s) > N / 2)
				break;
		}
		System.out.println(cnt);

	}
}