package ps.BOJ._15000_19999.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 488,372kb
// 948ms

public class Main_17070_파이프_옮기기_1 {

	static class pipe {
		int r,c,dir;
		pipe(int r,int c,int dir){
			this.r=r; this.c=c; this.dir=dir;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;

	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int cnt =0;
		Queue<pipe> q = new LinkedList<>();
		q.add(new pipe(0,1,0));
		while(!q.isEmpty()) {
			pipe cur = q.poll();
			if(cur.r==N-1&&cur.c==N-1) {
				cnt++;
				continue;
			}
			pipe curR = right(cur);
			pipe curRD = rightdown(cur);
			pipe curD = down(cur);
			if(curR!=null) q.add(curR);
			if(curRD!=null) q.add(curRD);
			if(curD!=null) q.add(curD);
		}
		bw.write(Integer.toString(cnt));
		bw.flush();bw.close();
	}
	
	// 이동. 불가능시 null 반환, 가능시 pipe객체 반환
	public static pipe right(pipe p) {
		// 45도 틀어서 갈 수 없는 경우, 오른 쪽이 맵 밖인 경우, 벽인 경우
		if(p.dir==2 || p.c+1==N || map[p.r][p.c+1]==1) return null;
		return new pipe(p.r,p.c+1,0);
	}
	public static pipe rightdown(pipe p) {
		// 오른 쪽, 아래가 맵 밖인 경우, 벽인 경우
		if(p.c+1==N||p.r+1==N) return null;
		if(map[p.r][p.c+1]==1||map[p.r+1][p.c]==1||map[p.r+1][p.c+1]==1) return null;
		return new pipe(p.r+1,p.c+1,1);
	}
	public static pipe down(pipe p) {
		// 45도 틀어서 갈 수 없는 경우, 아래가 맵 밖인 경우, 벽인 경우
		if(p.dir==0||p.r+1==N||map[p.r+1][p.c]==1) return null;
		return new pipe(p.r+1,p.c,2);
	}
}