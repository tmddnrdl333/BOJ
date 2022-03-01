package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 46,768kb
// 640ms

public class Main_1931_회의실_배정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] arr;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		bw.write(Integer.toString(meeting()));
		bw.flush();
		bw.close();
	}

	public static int meeting() {
		list.add(arr[0]);
		for (int i = 1; i < N; i++) {
			if (arr[i][0] >= list.get(list.size() - 1)[1]) {
				list.add(arr[i]);
			}
		}
		return list.size();
	}
}