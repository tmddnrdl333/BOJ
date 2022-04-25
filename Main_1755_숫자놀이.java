package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 11,708kb
// 76ms

public class Main_1755_숫자놀이 {

// 숫자와 그 읽는 법
	static class Num implements Comparable<Num> {
		String eng;
		int num;

		public Num(String eng, int num) {
			this.eng = eng;
			this.num = num;
		}

		@Override
		public int compareTo(Num o) { // 우선순위 큐에서 순서를 결정할 방법 (String의 오름차순)
			return this.eng.compareTo(o.eng);
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder res = new StringBuilder(); // 결과를 출력하기 위한 스트링빌더

	static int M, N;
	// 숫자와 읽는 법을 오름차순으로 채워줄 우선순위 큐
	static PriorityQueue<Num> pq = new PriorityQueue<>();
	// 각 한자리 숫자를 읽는 법
	static String[] num = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		fillPq(); // M과 N으로 pq를 채움
		int i = 0;
		while (!pq.isEmpty()) { // pq가 빌 때까지 뽑아서 출력
			Num cur = pq.poll();
			if (i != 0 && i % 10 == 0) // 열 번째마다 줄바꿈
				res.append("\n");
			res.append(cur.num + " "); // 스트링빌더에 저장
			i++;
		}
		// 결과 출력
		bw.write(res.toString());
		bw.flush();
		bw.close();
	}

	// M부터 N까지 읽는 법을 순서대로 채우기 위해
	// num배열을 이용해서 모든 숫자에 해당하는 읽는 법을 찾아줌.
	public static void fillPq() {
		for (int i = M; i <= N; i++) {
			StringBuilder sb = new StringBuilder();
			if (i / 10 != 0) // 십의 자리가 존재한다면 채워줌
				sb.append(num[i / 10] + " ");
			sb.append(num[i % 10]); // 일의 자리
			pq.offer(new Num(sb.toString(), i));
		}

	}

}
