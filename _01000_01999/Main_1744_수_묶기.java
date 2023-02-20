package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11,616kb
// 80ms

public class Main_1744_수_묶기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] minus = new int[N];
		int[] plus = new int[N];
		int[] zero = new int[3];
		int m = 0, p = 0;
		Arrays.fill(plus, 1001);
		Arrays.fill(minus, 1001);
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			if (cur < -1)
				minus[m++] = cur;
			else if (cur > 1)
				plus[p++] = cur;
			else {
				zero[cur + 1]++;
			}
		}

		Arrays.sort(minus);
		Arrays.sort(plus);

//		System.out.println(Arrays.toString(minus));
//		System.out.println(Arrays.toString(plus));

		int sum = 0;

		int i = 0;
		while (i < m - 1) { // 짝수개 만큼 곱해서 더하기
			sum += (minus[i] * minus[i + 1]);
			i += 2;
		}

//		System.out.println(sum);

		if (i == m - 1) { // 하나 남았다면?
			if (zero[0] != 0) { // -1이 하나 이상 있다면 곱해서 더해줌
				sum -= minus[i];
				zero[0]--;
			} else if (zero[1] != 0) { // -1이 없는데 0은 있다면 곱해서 없애줌
				zero[1]--; // minus[i]는 0과 곱해져서 사라짐
			} else { // -1도 없고 0도 없다면 어쩔 수 없이 더해줌
				sum += minus[i];
			}
		}

//		System.out.println(sum);

		if (zero[0] != 0) {
			sum += zero[0] / 2; // 짝수개 만큼 묶어서 곱하고 1로 만들어 더해준 것
			if (zero[0] % 2 != 0) { // 홀수개라면,
				if (zero[1] != 0) { // 0이 있다면 없앨 수 있지만
					zero[1]--;
				} else { // 아니라면 못없애고 1 빼줌
					sum--;
				}
			}
		}

//		System.out.println(sum);

		i = p - 1;
		while (i > 0) { // 짝수개 만큼 곱해서 더하기
			sum += (plus[i] * plus[i - 1]);
			i -= 2;
		}

//		System.out.println(sum);

		if (i == 0) { // 하나 남았다면?
			sum += plus[0];
		}

//		System.out.println(sum);

		if (zero[2] != 0)
			sum += zero[2];

		System.out.println(sum);

	}
}