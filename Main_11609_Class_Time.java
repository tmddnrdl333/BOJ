package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//
//

public class Main_11609_Class_Time {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		Arrays.sort(arr, (o1, o2) -> (o1[1].compareTo(o2[1]) == 0 ? o1[0].compareTo(o2[0]) : o1[1].compareTo(o2[1])));
		for (String[] strs : arr)
			sb.append(strs[0]).append(" ").append(strs[1]).append("\n");
		sb.setLength(sb.length() - 1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
