package ps.BOJ._15000_19999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 14,448kb
// 116ms

public class Main_17135_캐슬_디펜스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N,M,D;
	static int[][] map, curmap;
	static int[] archer;
	static int cnt,res;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		curmap = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				curmap[i][j] = map[i][j];
			}
		}
		archer = new int[M];
		archer[M-1]=1;
		archer[M-2]=1;
		archer[M-3]=1;
		do {
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					curmap[i][j]=map[i][j];
			cnt=0;
			play();
			res = cnt>res?cnt:res;
		} while(np());
		
		bw.write(Integer.toString(res));
		bw.flush();bw.close();
	}
	
	public static void play() {
		// N행에 있다 치고 쏘고, 한 칸씩 땡기기
		for(int r = N;r!=0;r--) {
			// 쏠 적 저장할 큐
			Queue<int[]> q = new LinkedList<>();
			
			for(int i=0;i<M;i++)
				if(archer[i]==1) {
					int[] enemy = shoot(r,i);
					if(enemy!=null)
						q.add(enemy);
				}
			while(!q.isEmpty()) {
				int er = q.peek()[0], ec = q.poll()[1];
				if(curmap[er][ec]==1) {
					cnt++;
					curmap[er][ec]=0;
				}
			}
		}
	}
	
	// 쏜 적의 좌표 반환
	public static int[] shoot(int r, int c) {
		for(int i=0;i<D;i++) {
			int nr = r-1;
			int nc = c-i;
			for(int j=0;j<=2*i;j++) {
				if(nr>=0&&nc>=0&&nr<N&&nc<M) {
					if(curmap[nr][nc]==1) return new int[] {nr,nc};
				}
				nc++;
				if(j<i) nr--;
				else nr++;
			}
		}
		return null;
	}
	
	public static boolean np() {
		int i=M-1;
		while(i>0 && archer[i-1]>=archer[i]) --i;
		if(i==0) return false;
		int j=M-1;
		while(archer[i-1]>=archer[j]) --j;
		swap(i-1,j);
		int k=M-1;
		while(i<k) swap(i++,k--);
		return true;
	}
	public static void swap(int i,int j) {
		int temp = archer[i];
		archer[i]=archer[j];
		archer[j]=temp;
	}
}