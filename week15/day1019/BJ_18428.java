package week15.day1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_18428 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean status;
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') {
					list.add(new int[] {i,j});
				}
			}
		}
		dfs(0,0,0);
		if(status) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	private static void dfs(int r,int c, int cnt) {
		if(status) {
			
			return;
		}
		if(cnt==3) {
			status = find() || status;
			return;
		}
		
		for(int i=r; i<N; i++) {
			for(int j=c; j<N; j++) {
				if(map[i][j]=='X') {
					map[i][j] = 'O';
//					if(j==N-1) {
//						dfs(i+1,0,cnt+1);
//					}else {
						dfs(i,j+1,cnt+1);
//					}
					map[i][j] = 'X';						
				}
			}
			c=0;
		}
	}
	private static boolean find() {
		
		for(int l=0; l<list.size(); l++) {
			int[] arr = list.get(l);
			for(int d=0; d<4; d++) {
				int nr = arr[0]; 
				int nc = arr[1];
				while(true) {
					nr += deltas[d][0];
					nc += deltas[d][1];
					if(!isIn(nr,nc)|| map[nr][nc]=='O') {
						break;
					}
					if(map[nr][nc] == 'S') {
						return false;
					}
					
				}
			}
		}
		return true;
	}
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr < N && 0<= nc && nc<N;
	}
}
