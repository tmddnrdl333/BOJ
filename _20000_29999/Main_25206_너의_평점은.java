package ps.BOJ._20000_29999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,772kb
// 80ms

public class Main_25206_너의_평점은 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		double sum = 0;
		double points = 0;
		outer: for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			double point = Double.parseDouble(st.nextToken());
			double score = 0;
			String res = st.nextToken();
			char r1 = res.charAt(0);
			switch (r1) {
			case 'A':
				if (res.charAt(1) == '+')
					score = 4.5;
				else
					score = 4;
				break;
			case 'B':
				if (res.charAt(1) == '+')
					score = 3.5;
				else
					score = 3;
				break;
			case 'C':
				if (res.charAt(1) == '+')
					score = 2.5;
				else
					score = 2;
				break;
			case 'D':
				if (res.charAt(1) == '+')
					score = 1.5;
				else
					score = 1;
				break;
			case 'P':
				continue outer;
			case 'F':
				break;
			}
			sum += point * score;
			points += point;
		}
		bw.write(sum / points + "");
		bw.flush();
		bw.close();
	}
}