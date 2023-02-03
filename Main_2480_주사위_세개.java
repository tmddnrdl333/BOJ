package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11,596kb
// 80ms

public class Main_2480_주사위_세개 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int sum = 0;
		if (arr[0] == arr[1] && arr[1] == arr[2])
			sum = 10000 + arr[0] * 1000;
		else if (arr[0] == arr[1])
			sum = 1000 + arr[0] * 100;
		else if (arr[1] == arr[2])
			sum = 1000 + arr[1] * 100;
		else if (arr[0] == arr[2])
			sum = 1000 + arr[0] * 100;
		else {
			int max = arr[0] > arr[1] ? arr[0] : arr[1];
			max = arr[2] > max ? arr[2] : max;
			sum = max * 100;
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}