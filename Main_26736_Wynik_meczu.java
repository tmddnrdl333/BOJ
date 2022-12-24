package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 14,244kb
// 92ms

public class Main_26736_Wynik_meczu {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		char[] arr = br.readLine().toCharArray();
		int a = 0, b = 0;
		for (char c : arr) {
			if (c == 'A')
				a++;
			else
				b++;
		}
		bw.write(a + " : " + b);
		bw.flush();
		bw.close();
	}
}