package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,568kb
// 76ms

public class Main_2920_음계 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		char init = str.charAt(0);
		if (init == '1' && str.equals("1 2 3 4 5 6 7 8")) {
			bw.write("ascending");
		} else if (init == '8' && str.equals("8 7 6 5 4 3 2 1")) {
			bw.write("descending");
		} else {
			bw.write("mixed");
		}
		bw.flush();
		bw.close();
	}
}