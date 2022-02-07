package boj0207;

import java.util.Scanner;

public class Main_17478 {
	static String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
	static String q = "\"재귀함수가 뭔가요?\"";
	static String[] a1 = { "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" };
	static String a2 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	static String a3 = "라고 답변하였지.";
	static String u = "____";
	static StringBuilder sb = new StringBuilder();
	static int n;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();

		System.out.println(start);
		talk(0);
		System.out.println(sb);
	}

	public static void talk(int cnt) {
		if (cnt == n) {
			addUnderLine(cnt);
			sb.append(q + "\n");
			addUnderLine(cnt);
			sb.append(a2 + "\n");
			addUnderLine(cnt);
			sb.append(a3 + "\n");
			return;
		}

		addUnderLine(cnt);
		sb.append(q + "\n");
		for (int i = 0; i < 3; i++) {
			addUnderLine(cnt);
			sb.append(a1[i] + "\n");
		}
		talk(cnt + 1);
		addUnderLine(cnt);
		sb.append(a3 + "\n");
	}

	public static void addUnderLine(int n) {
		for (int i = 0; i < n; i++)
			sb.append(u);
	}

}
