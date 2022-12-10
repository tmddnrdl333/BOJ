package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 11744kb
// 88ms

public class Main_16499_동일한_단어_그룹화하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(toSortedString(br.readLine()));
		bw.write(set.size() + "");
		bw.flush();
		bw.close();
	}

	static String toSortedString(String str) {
		char[] arr = new char[str.length()];
		arr = str.toCharArray();
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++)
			sb.append(arr[i]);
		return sb.toString();
	}
}