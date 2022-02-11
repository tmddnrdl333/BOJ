package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11636kb
// 76ms

public class boj10_10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		//
		int rx = 0, ry = 0;
		if (((x + t) / w) % 2 == 0) {
			rx = (x + t) % w;
		} else
			rx = w - (x + t) % w;
		if (((y + t) / h) % 2 == 0) {
			ry = (y + t) % h;
		} else
			ry = h - (y + t) % h;
		bw.write(rx + " " + ry);
		bw.flush();
		bw.close();
	}
}
