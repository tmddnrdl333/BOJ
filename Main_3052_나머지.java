package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// 11,548kb
// 76ms

public class Main_3052_나머지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			int a = Integer.parseInt(br.readLine());
			set.add(a % 42);
		}
		bw.write(set.size() + "");
		bw.flush();
		bw.close();
	}
}