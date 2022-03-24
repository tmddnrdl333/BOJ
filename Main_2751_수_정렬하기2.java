package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 214,308kb
// 1452ms

public class Main_2751_수_정렬하기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(br.readLine()));
		Collections.sort(list);
		for (int i = 0; i < N; i++)
			sb.append(list.get(i)).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}