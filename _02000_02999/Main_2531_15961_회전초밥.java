package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 168,820kb
// 508ms

public class Main_2531_15961_회전초밥 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N, d, k, c;
	static int[] arr;
	static int[] count;
	static int res = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int total = 0;
		count = new int[d + 1];
		count[c]++;
		total++;
		for (int i = 0; i < k; i++) {
			if (count[arr[i]] == 0)
				total++;
			count[arr[i]]++;
		}

		for (int i = 0; i < N; i++) {
			res = total > res ? total : res;
//			System.out.println(i + " " + res);
//			System.out.println(Arrays.toString(count));
			if (count[arr[i]] == 1)
				total--;
			count[arr[i]]--;
			if (count[arr[(i + k) % N]] == 0)
				total++;
			count[arr[(i + k) % N]]++;
		}
		bw.write(Integer.toString(res));
		bw.flush();
		bw.close();
	}
}
