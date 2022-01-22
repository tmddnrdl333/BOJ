import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj11729_0122 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		bw.write(hanoi(N) + "\n");

		moveHanoi(N, 1, 3);

		bw.flush();
		bw.close();
	}

	static int hanoi(int N) {
		if (N == 1) {
			return 1;
		}
		N = 1 + 2 * hanoi(N - 1);
		return N;
	}

	static void moveHanoi(int N, int now, int goal) throws IOException {
		int temp = 6 - now - goal;
		if (N == 1) {
			bw.write(now + " " + goal + "\n");
			return;
		}

		moveHanoi(N - 1, now, temp);
		bw.write(now + " " + goal + "\n");
		moveHanoi(N - 1, temp, goal);

	}
}
