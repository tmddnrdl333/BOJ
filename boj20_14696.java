package IM_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 37636kb
// 456ms

public class boj20_14696 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringBuilder res = new StringBuilder();
		StringBuilder Asb = new StringBuilder();
		StringBuilder Bsb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Alen = Integer.parseInt(st.nextToken());
			Integer[] Aarr = new Integer[Alen];
			for (int j = 0; j < Alen; j++)
				Aarr[j] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int Blen = Integer.parseInt(st.nextToken());
			Integer[] Barr = new Integer[Blen];
			for (int j = 0; j < Blen; j++)
				Barr[j] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(Aarr, Collections.reverseOrder());
			Arrays.sort(Barr, Collections.reverseOrder());
			
			int max = Math.max(Alen, Blen);
			for (int j = 0; j < max; j++) {
				if (j < Alen)
					Asb.append(Aarr[j]);
				else
					Asb.append("0");
			}
			for (int j = 0; j < max; j++) {
				if (j < Blen)
					Bsb.append(Barr[j]);
				else
					Bsb.append("0");
			}
			
			int tmp = Asb.toString().compareTo(Bsb.toString());
			if (tmp > 0)
				res.append("A\n");
			else if (tmp == 0)
				res.append("D\n");
			else
				res.append("B\n");
			
			Asb.setLength(0);
			Bsb.setLength(0);
		}
		res.setLength(2 * N - 1);
		bw.write(res.toString());
		bw.flush();
		bw.close();
	}
}
