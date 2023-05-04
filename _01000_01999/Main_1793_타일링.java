package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 12,392kb
// 96ms

public class Main_1793_타일링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		List<Integer> list = new ArrayList<>();
		int max = 0;
		while (true) {
			String input = br.readLine();
			if (input == null || input.isEmpty())
				break;
			int n = Integer.parseInt(input);
			max = n > max ? n : max;
			list.add(n);
		}

		List<BigInteger> dp = new ArrayList<>();

		dp.add(BigInteger.ONE);
		dp.add(BigInteger.ONE);
		dp.add(BigInteger.valueOf(3));
		int idx = 3;
		for (; idx <= max; idx++) {
			BigInteger next = dp.get(idx - 2).multiply(BigInteger.valueOf(2)).add(dp.get(idx - 1));
			dp.add(next);
		}

		for (int el : list)
			sb.append(dp.get(el) + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}