import java.util.Scanner;

public class bj11729plus_0122 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(hanoi(N));
		moveHanoi(N, 1, 3);
	}

	static int hanoi(int N) {
		if (N == 1) {
			return 1;
		}
		N = 1 + 2 * hanoi(N - 1);
		return N;
	}

	static void moveHanoi(int N, int now, int goal) {
		int temp = 6 - now - goal;
		if (N == 1) {
			System.out.printf("%d %d\n", now, goal);
			return;
		}

		moveHanoi(N - 1, now, temp);
		System.out.printf("%d %d\n", now, goal);
		moveHanoi(N - 1, temp, goal);

	}
}