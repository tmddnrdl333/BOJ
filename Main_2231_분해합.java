package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,652kb
// 104ms

public class Main_2231_분해합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int i = 1, sum = 0;
		while (true) {
			sum = i + makeSum(i);
			if (sum == N) {
				break;
			} else if (i >= N) {
				i = 0;
				break;
			}
			i++;
		}
		bw.write(Integer.toString(i));
		bw.flush();
		bw.close();

	}

	public static int makeSum(int i) {
		int ret = 0;
		while (i != 0) {
			ret += i % 10;
			i /= 10;
		}
		return ret;
	}
}