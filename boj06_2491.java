package IM_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj06_2491 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N < 2) {
			System.out.println(N);
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> u = new Stack<>();
		Stack<Integer> d = new Stack<>();
		int first = Integer.parseInt(st.nextToken());
		u.push(first);
		d.push(first);
		int umax = 0;
		int dmax = 0;
		for (int i = 1; i < N; i++) {
			int current = Integer.parseInt(st.nextToken());
			if (current < u.peek())
				u.clear();
			u.push(current);
			if (current > d.peek())
				d.clear();
			d.push(current);
			umax = u.size() > umax ? u.size() : umax;
			dmax = d.size() > dmax ? d.size() : dmax;
		}
		System.out.println(Math.max(umax, dmax));

	}
}
