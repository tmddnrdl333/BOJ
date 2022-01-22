import java.util.Scanner;

public class bj10872_0122 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(fact(N));
	}

	static int fact(int N) {
		if (N == 0) {
			return N+1;
		}

		N = N * fact(N - 1);
		return N;
	}
}
