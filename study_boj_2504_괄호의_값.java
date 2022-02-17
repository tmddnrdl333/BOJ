package study.day0216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 11,608kb
// 72ms

public class study_boj_2504_괄호의_값 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static char[] inputC;
	static int[] inputI;
	static int len;

	public static void main(String[] args) throws IOException {
		inputC = br.readLine().toCharArray();
		len = inputC.length;
		inputI = new int[len];
		charToInt();

		if (isValid()) {
			bw.write(Integer.toString(calc(0, len - 1)));
		} else {
			bw.write(Integer.toString(0));
		}
		bw.flush();
		bw.close();
	}

	// 입력받은 char배열을 int배열로 전환
	public static void charToInt() {
		for (int i = 0; i < len; i++) {
			char tmp = inputC[i];
			if (tmp == '[')
				inputI[i] = 3;
			else if (tmp == ']')
				inputI[i] = 13;
			else if (tmp == '(')
				inputI[i] = 2;
			else
				inputI[i] = 12;
		}
	}

	// 계산이 가능한지 확인
	public static boolean isValid() {
		Stack<Integer> stack = new Stack<>();
		stack.push(inputI[0]); // 일단 첫번째 넣기
		for (int i = 1; i < len; i++) {
			if (!stack.isEmpty() && stack.peek() == inputI[i] - 10) // stack 직전걸 닫아주는 괄호 발견
				stack.pop();
			else
				stack.push(inputI[i]);
		}
		return stack.isEmpty();
	}

	// 계산 함수
	// 1. start가 여는 괄호여야 함. 아니면 즉시 종료
	// - start를 닫아주는 괄호를 찾으면, calc(start+1,i-1)를 호출해주고, 그 함수가 반환한 값에 *2 or *3 해줌
	// - calc(i+1,end)를 호출하고 반환값을 더해줌
	public static int calc(int start, int end) {

		// !! 처음부터 입력이 틀린 경우
		// 닫는 괄호라면, 입력이 틀렸다 -> 0 반환
		if (inputI[start] > 10)
			return 0;

		// 기본 조건 (2는 +유도)
		// 1. () / [] 인 경우
		// - 가장 작은 단위이므로 바로 2 / 3 반환
		// 2. () / [] 로 시작해서 뒤에 더 있는 경우
		// - 2 / 3 + 뒤 남은 고려대상의 결과 반환
		if (inputI[start] + 10 == inputI[start + 1]) {
			if (start + 1 == end) // () 이거나 []하고 끝인 경우
				return inputI[start];
			else { // 그 뒤에도 있는 경우
				return inputI[start] + calc(start + 2, end);
			}
		}

		// 유도 조건
		Stack<Integer> stack = new Stack<>();
		stack.push(inputI[start]); // 일단 첫번째 넣기

		// 시작의 여는 괄호를 닫아주는 괄호가 나오면
		// 그 기준으로 쪼개기
		for (int i = start + 1; i <= end; i++) {
			if (stack.peek() == inputI[i] - 10) { // stack 직전걸 닫아주는 괄호 발견
				int mult = stack.pop();
				if (stack.isEmpty()) { // 만약 stack이 비워진다면, 첫 괄호가 닫아졌다는 뜻
					// 1. 마지막에 닫아진거라면, 그냥 곱한 값을 반환
					// 2. 중간에 닫아진거라면, 곱한 값 + 나머지 남은 고려대상의 결과 반환
					if (i == end)
						return mult * calc(start + 1, i - 1);
					else
						return mult * calc(start + 1, i - 1) + calc(i + 1, end);
				}
			} else
				stack.push(inputI[i]);
		}

		return 10000;
		// 잘못된 경우 이 함수를 들어올 일이 없기 때문에
		// 앞의 조건에 모두 걸려서 여기까지 오지 않을 것.

	}
}
