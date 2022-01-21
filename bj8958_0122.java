import java.util.Scanner;

public class bj8958_0122 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		for (int i = 0; i < n; i++) {
			int score = 0;
			int tmp = 0;
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == 'X') {
					tmp = 0;
				} else if (arr[i].charAt(j) == 'O') {
					tmp++;
					score += tmp;
				}
			}
			System.out.println(score);
		}

	}
}
