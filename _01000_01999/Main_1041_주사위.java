package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 11804kb
// 80ms

public class Main_1041_주사위 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BigInteger N;
		int[] dice = new int[6];
		N = new BigInteger(br.readLine());
		st = new StringTokenizer(br.readLine());
		if (BigInteger.valueOf(1).compareTo(N) == 0) {
			int max = 0, sum = 0;
			for (int i = 0; i < 6; i++) {
				int temp = Integer.parseInt(st.nextToken());
				sum += temp;
				max = temp > max ? temp : max;
			}
			bw.write((sum - max) + "");
			bw.flush();
			bw.close();
		} else {
			int min1 = 999;
			for (int i = 0; i < 6; i++) {
				dice[i] = Integer.parseInt(st.nextToken());
				min1 = dice[i] < min1 ? dice[i] : min1;
			}
			int min2 = 999, min3 = 999;
			int[][] twos = { { 0, 1 }, { 1, 5 }, { 5, 4 }, { 4, 0 }, { 0, 2 }, { 2, 5 }, { 5, 3 }, { 3, 0 }, { 1, 2 },
					{ 2, 4 }, { 4, 3 }, { 3, 1 } };
			int[][] threes = { { 0, 1, 2 }, { 0, 1, 3 }, { 0, 4, 2 }, { 0, 4, 3 }, { 5, 1, 2 }, { 5, 1, 3 },
					{ 5, 4, 2 }, { 5, 4, 3 } };
			for (int i = 0; i < 12; i++) {
				int temp2 = dice[twos[i][0]] + dice[twos[i][1]];
				min2 = temp2 < min2 ? temp2 : min2;
			}
			for (int i = 0; i < 8; i++) {
				int temp3 = dice[threes[i][0]] + dice[threes[i][1]] + dice[threes[i][2]];
				min3 = temp3 < min3 ? temp3 : min3;
			}
			BigInteger c1 = N.multiply(N).multiply(BigInteger.valueOf(5)).subtract(N.multiply(BigInteger.valueOf(16)))
					.add(BigInteger.valueOf(12));
			BigInteger c2 = N.multiply(BigInteger.valueOf(8)).subtract(BigInteger.valueOf(12));
			BigInteger c3 = BigInteger.valueOf(4);
			BigInteger res = c1.multiply(BigInteger.valueOf(min1)).add(c2.multiply(BigInteger.valueOf(min2)))
					.add(c3.multiply(BigInteger.valueOf(min3)));
			bw.write(res + "");
			bw.flush();
			bw.close();
		}
	}
}