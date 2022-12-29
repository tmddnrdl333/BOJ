package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11,580kb
// 76ms

public class Main_20004_베스킨라빈스_31 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int A = Integer.parseInt(br.readLine());
		for (int i = 1; i <= A; i++) {
			if (30 % (i + 1) == 0)
				sb.append(i).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}