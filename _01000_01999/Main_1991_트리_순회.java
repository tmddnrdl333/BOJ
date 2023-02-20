package ps.BOJ._01000_01999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11600kb
// 76ms

public class Main_1991_트리_순회 {
	static class Node {
		int left, right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	static Node[] nodes;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int cur = str.charAt(0) - 'A';
			int left = str.charAt(2) - 'A';
			int right = str.charAt(4) - 'A';
			nodes[cur] = new Node(left, right);
		}

		// 전위 순회
		preorder(0);
		sb.append("\n");
		// 중위 순회
		inorder(0);
		sb.append("\n");
		// 후위 순회
		postorder(0);
		sb.append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void preorder(int num) {
		int left = nodes[num].left, right = nodes[num].right;
		sb.append((char) (num + 'A'));
		if (left > 0)
			preorder(left);
		if (right > 0)
			preorder(right);
	}

	public static void inorder(int num) {
		int left = nodes[num].left, right = nodes[num].right;
		if (left > 0)
			inorder(left);
		sb.append((char) (num + 'A'));
		if (right > 0)
			inorder(right);
	}

	public static void postorder(int num) {
		int left = nodes[num].left, right = nodes[num].right;
		if (left > 0)
			postorder(left);
		if (right > 0)
			postorder(right);
		sb.append((char) (num + 'A'));
	}

}