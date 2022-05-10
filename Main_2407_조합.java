package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 11,720kb
// 80ms

public class Main_2407_조합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BigInteger[] denom = new BigInteger[m + 1];
		denom[1] = BigInteger.ONE;
		for (int i = 2; i <= m; i++)
			denom[i] = denom[i - 1].multiply(BigInteger.valueOf(i));
		BigInteger[] numer = new BigInteger[n + 1];
		numer[n - m + 1] = BigInteger.valueOf(n - m + 1);
		for (int i = n - m + 2; i <= n; i++)
			numer[i] = numer[i - 1].multiply(BigInteger.valueOf(i));
		System.out.println(numer[n].divide(denom[m]));
	}
}