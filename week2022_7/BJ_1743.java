package week2022_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1743 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K;
	static boolean[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static int max;
	static List<Node> list;
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		max = 0;
		list = new ArrayList<>();
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = true;
			list.add(new Node(r, c));
		}
		
		bfs();
		System.out.println(max);
		
	}

	private static void bfs() {
		
		boolean[][] visited = new boolean[N][M];
		Queue<Node> Q = new LinkedList<Node>();
		int size = list.size();
		for(int s=0; s<size; s++) {
			int r = list.get(s).r;
			int c = list.get(s).c;
			if(visited[r][c] == true) {
				continue;
			}
			Q.add(new Node(r, c));
			int cnt = 0;
			while(!Q.isEmpty()) {
				Node node = Q.poll();
				
				for(int d=0; d<4; d++) {
					int nr = node.r + deltas[d][0];
					int nc = node.c + deltas[d][1];
					
					if(isIn(nr, nc) && map[nr][nc] && !visited[nr][nc]) {
						Q.add(new Node(nr, nc));
						visited[nr][nc] = true;
						cnt++;
					}
					
				}
			}
			max = Math.max(max, cnt);
		}
		
		
	}
	
	static class Node{
		
		int r,c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}

}
