package ps.BOJ._10000_14999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 62,184kb
// 676ms

public class Main_10814_나이순_정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Member {
		int no;
		int age;
		String name;

		Member(int no, int age, String name) {
			this.no = no;
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		Member[] members = new Member[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members[i] = new Member(i, age, name);
		}
		Arrays.sort(members, (o1, o2) -> (o1.age == o2.age ? o1.no - o2.no : o1.age - o2.age));

		for (Member member : members)
			sb.append(member.age + " " + member.name + "\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}