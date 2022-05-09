package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11,508kb
// 76ms

public class Main_2292_벌집 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int cnt = 1, num = 1, add = 6;
		while (true) {
			if (N > num) {
				num += add;
				add += 6;
				cnt++;
			} else
				break;
		}
		System.out.println(cnt);
	}
}