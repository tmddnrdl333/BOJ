package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,592kb
// 76ms

public class Main_2753_윤년 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		if (N % 4 == 0 && (N % 100 != 0 || N % 400 == 0))
			bw.write("1");
		else
			bw.write("0");

		bw.flush();
		bw.close();
	}
}