package week2022_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17129 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N, M, min;
	static Queue<Node> Q;
	

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		Q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 2) {
					Q.add(new Node(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		min = Integer.MAX_VALUE;
		bfs();
		if(min == Integer.MAX_VALUE) {
			sb.append("NIE");
		}else {
			sb.append("TAK\n").append(min);
		}
		System.out.println(sb.toString());
		
	}

	private static void bfs() {
		
		while(!Q.isEmpty()) {
			Node now = Q.poll();
			for(int d=0; d<4; d++) {
				
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];
				
				if(isIn(nr,nc) && map[nr][nc] != 1 && !visited[nr][nc]) {
					if(map[nr][nc] == 0) {
						visited[nr][nc] = true;
						Q.add(new Node(nr, nc, now.distance+1));
					}else {
						min = now.distance+1;
						return;
					}
					
				}
				
				
			}
			
			
			
		}
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}

	static class Node{
		int r,c;
		int distance;
		
		public Node(int r, int c, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
		
		
		
	}

}
