package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_15740_A_B_9 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		BigInteger bn1 = new BigInteger(st.nextToken());
		BigInteger bn2 = new BigInteger(st.nextToken());
		bw.write(bn1.add(bn2).toString());
		bw.flush();
		bw.close();
	}
}