package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11401_이항_계수_3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, K;
	static long[] fac;
	static final long p = 1000000007;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K == 0 || N == K) {
			System.out.println(1);
			return;
		}

		fac = new long[N + 1];
		fac[1] = 1;
		for (int i = 2; i <= N; i++) {
			fac[i] = fac[i - 1] % p * i % p;
		}

		bw.write(Long.toString(comb(N, K)));
		bw.flush();
		bw.close();
	}

	public static long pow(long a, long b) {
		if (b == 0)
			return 1;
		long res = pow(a, b / 2) % p;
		if (b % 2 == 0)
			return (res % p) * (res % p) % p;
		else
			return ((res % p) * (res % p) % p) * a % p;
	}

	public static long comb(int n, int r) {
		long res = ((fac[n] % p) * (pow(fac[n - r], p - 2) % p) % p) * (pow(fac[r], p - 2) % p);
		return res % p;
	}
}