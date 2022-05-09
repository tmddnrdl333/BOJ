package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,564kb
// 80ms

public class Main_15829_Hashing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int INF = 1234567891;

	public static void main(String[] args) throws IOException {
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char[] arr = str.toCharArray();
		long r = 1;
		long H = 0;
		for (int i = 0; i < L; i++) {
			H += ((arr[i] - 'a' + 1) * r) % INF;
			r = (r * 31) % INF;
		}
		System.out.println(H % INF);
	}
}