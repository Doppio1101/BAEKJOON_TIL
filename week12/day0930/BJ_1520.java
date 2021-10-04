package week12.day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1520 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[][] map;
	static int[][] visited;
	static int[][] deltas = {{0,-1},{0,1},{-1,0},{1,0}};
	static int cnt;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];//원래 boolean 2차원 배열이었으나 시간초과로 DP형태로 바꿈.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}
		
		visited[N-1][M-1] = 1;
		//원래는 조건문으로 기저조건으로 사용했는데 1을 넣어줌으로 해서 기저조건을 만들어 줌.
		
		int result = dfs(0,0);
		
		System.out.println(result);
		
	}

	private static int dfs(int r, int c) {
//		if(r == N-1 && c == M-1) {	
//			
//			return 1;
//			
//		}
		
		if(visited[r][c] != -1) {
			return visited[r][c];
		}
		
		visited[r][c] = 0;
		//주석 추가 -> 원래는 -1로 하여금 방문하지 않았음을 표현 했고
		//0으로 초기화 하고 자식을 탐색하는 방법으로 방문을 체크해준다.
		
		for(int d=0; d<4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr,nc) &&  map[r][c] > map[nr][nc]) {
				visited[r][c] += dfs(nr,nc);
			}
		}
		
		return visited[r][c];
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	}
}
