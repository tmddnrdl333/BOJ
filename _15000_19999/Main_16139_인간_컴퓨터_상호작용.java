package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 107,392kb
// 608ms

public class Main_16139_인간_컴퓨터_상호작용 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		char[] arr = br.readLine().toCharArray();
		int len = arr.length;

		// 누적합 계산
		int sum[][] = new int[26][len + 1];
		// 첫 문자
		sum[arr[0] - 'a'][1] = 1;
		// ~ 마지막
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < 26; j++) {
				sum[j][i + 1] = sum[j][i];
			}
			sum[arr[i] - 'a'][i + 1]++;
		}

		// 질의
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int qc = st.nextToken().toCharArray()[0] - 'a';
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			sb.append(sum[qc][to + 1] - sum[qc][from]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}