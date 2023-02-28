package ps.BOJ._07000_07999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 52,900kb
// 640ms

public class Main_7785_회사에_있는_사람 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Set<String> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());

		for (; n > 0; n--) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			boolean isEnter = st.nextToken().charAt(0) == 'e';
			if (isEnter)
				set.add(name);
			else
				set.remove(name);
		}

		int len = set.size();
		String[] arr = new String[len];
		for (String name : set)
			arr[--len] = name;
		Arrays.sort(arr, Collections.reverseOrder());
		for (String name : arr)
			sb.append(name).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}