import java.util.Scanner;

public class bj11653_0122 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 2; i <= (int) Math.sqrt(N); i++) {
			if (primeTest(i) == false)
				continue;
			if (N % i != 0)
				continue;
			System.out.println(i);
			N = N / i;
			i = 1;
		}
		if (N != 1)
			System.out.println(N);

	}

	static boolean primeTest(int num) {
		if (num < 3) {
			return true;
		} else if (num % 2 != 0 && num > 2) {
			for (int i = 3; i <= (int) Math.sqrt(num); i += 2) {
				if (num % i != 0)
					continue;
				else
					return false;
			}
			return true;
		}
		return false;
	}
}
