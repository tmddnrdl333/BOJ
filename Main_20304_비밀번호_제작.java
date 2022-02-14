package boj0214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_20304_비밀번호_제작 {
	static int N, Nlen;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N : 관리자 패스워드 최대값
		N = Integer.parseInt(br.readLine());
		// NLen : N의 2진표현 자릿수
		Nlen = binLen(N);

		// M : 해커 시도 횟수
		int M = Integer.parseInt(br.readLine());
		// arr : 해커가 시도한 모든 패스워드 (2진표현)
		arr = new String[M];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			// i번째 시도한 패스워드
			int pw = Integer.parseInt(st.nextToken());
			// 이진 표현으로 저장
			arr[i] = toBin(pw);
		}
		// == 입력 끝 ==

		// max : 보안값 중 최대를 저장할 변수
		int max = 0;

		for (int i = 0; i <= N; i++) {
			// score : 관리자가 사용가능한 패스워드 i에 대한 최소 보안값
			int score = check(i);
			max = score > max ? score : max;
		}
		// 결과 출력
		bw.write(max + "");
		bw.flush();
		bw.close();
	}

	// : num에 대한 2진표현의 자릿수 반환
	public static int binLen(int num) {
		// 최대 20자리 (1000000)
		int last = 20;
		// num의 가장 높은 자리에 올 수 있을 때 까지 last 감소
		for (; last >= 0; last--) {
			if (num >= (int) Math.pow(2, last))
				break;
		}
		return last;
	}

	// : num을 Nlen길이만큼의 2진수로 반환
	public static String toBin(int num) {
		// sb : 반환할 결과 저장할 StringBuilder
		StringBuilder sb = new StringBuilder();
		// 2로 나눠지면 1 저장, 아니면 0 저장 -> 2진변환
		for (int i = Nlen; i >= 0; i--) {
			if (num >= (int) Math.pow(2, i)) {
				sb.append(1);
				num -= (int) Math.pow(2, i);
			} else
				sb.append(0);
		}
		return sb.toString();
	}

	// 관리자가 제시한 i에 대하여, 해커가 사용한 각 패스워드에 대한 보안값 반환
	// (i는 N보다 작거나 같은 수)
	public static int check(int i) {
		// str : i를 2진변환
		String str = toBin(i);
		// min : 보안척도 최소값(보안값)을 저장할 변수
		int min = 1000;
		// 모든 입력받은 해커의 패스워드에 대하여
		for (String pw : arr) {
			int cnt = 0;
			// 자릿수별로 다를 때마다 cnt+1
			for (int j = 0; j <= Nlen; j++) {
				if (str.charAt(j) != pw.charAt(j)) {
					cnt++;
				}
			}
			min = cnt < min ? cnt : min;
		}
		return min;
	}
}
