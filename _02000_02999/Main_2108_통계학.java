package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 40,028kb
// 268ms

public class Main_2108_통계학 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[8001];

		int sum = 0;
		int min = 4001, max = -4001;

		for (int i = 0; i < N; i++) {
			int inp = Integer.parseInt(br.readLine());
			nums[inp + 4000]++;
			sum += inp;
			min = inp < min ? inp : min;
			max = inp > max ? inp : max;
		}

		int cnt = 0, med = -4001;
		int maxCnt = 0, fre = -4001;
		boolean mFlag = true, fFlag = false;
		for (int i = 0; i < 8001; i++) {
			cnt += nums[i];
			if (cnt >= N / 2 + 1 && mFlag) {
				med = i - 4000;
				mFlag = false;
			}
			if (nums[i] > maxCnt) {
				maxCnt = nums[i];
				fre = i - 4000;
				fFlag = true;
			} else if (nums[i] == maxCnt && fFlag) {
				fre = i - 4000;
				fFlag = false;
			}
		}

		bw.write((int) Math.round((double) sum / N) + "\n" + med + "\n" + fre + "\n" + (max - min));
		bw.flush();
		bw.close();

	}
}