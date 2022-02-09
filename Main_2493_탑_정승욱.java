package algorithm_ws.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑_정승욱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] res = new int[N]; // 결과 저장할 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>(); // 몇짜리가 몇번인덱스에
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			while (true) {
				if (stack.isEmpty()) { // 시야에 걸리는 게 없다면 : 0
					stack.push(new int[] { tmp, i }); // tmp 내가 들어갈테니 다음엔 보이는지 확인해봐
					res[i] = 0;
					break; // 기록했으니 다음 i
				} else if (stack.peek()[0] < tmp) { // tmp 내 시야 만들기1. 앞에 나보다 작다면 안보이게 pop
					stack.pop();
				} else if (stack.peek()[0] == tmp) { // tmp 내 시야 만들기2+기록. 앞이 나랑 같다면 : 기록하고 pop하고 push.
					res[i] = stack.peek()[1] + 1; // 기록해주고
					stack.pop(); // 앞에 같은 애 빼주고
					stack.push(new int[] { tmp, i }); // 대신 tmp 내가 들어가주고
					break; // 기록했으니 다음 i
				} else if (stack.peek()[0] > tmp) { // tmp 내 시야에 나보다 큰 애 발견. 기록하고 push.
					res[i] = stack.peek()[1] + 1; // 기록해주고
					stack.push(new int[] { tmp, i }); // 넣기
					break; // 기록했으니 다음 i
				}
			}
		}

		for (int i = 0; i < N; i++)
			System.out.print(res[i] + " ");

		//

	}
}
