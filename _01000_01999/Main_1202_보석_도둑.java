package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 129,132kb
// 1,952ms

public class Main_1202_보석_도둑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Gem {
		int M, V;

		Gem(int M, int V) {
			this.M = M;
			this.V = V;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Gem[] gems = new Gem[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			gems[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(gems, (o1, o2) -> o1.M - o2.M);

		int[] bags = new int[K];

		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);

		PriorityQueue<Gem> gems2 = new PriorityQueue<>((o1, o2) -> (o1.V == o2.V ? o2.M - o1.M : o2.V - o1.V));
		long res = 0;

		int gi = 0;
		for (int i = 0; i < K; i++) {
			while (gi < N && gems[gi].M <= bags[i])
				gems2.add(gems[gi++]);
			if (!gems2.isEmpty())
				res += gems2.poll().V;
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}
