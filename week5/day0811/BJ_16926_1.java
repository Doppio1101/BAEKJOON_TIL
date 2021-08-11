package week5.day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16926_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map;
	static int N,M,R;
	static int[][] turnMap;
	static Deque<Integer> turnQ;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		turn(N,M,0);
		
		for(int[] a:map) {
			for(int b : a) {
				sb.append(b+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void turn(int n, int m,int c) {
		// TODO Auto-generated method stub
		if(n==c||m==c||c==R) {
			return;
		}
		turnQ = new LinkedList<>();
		
//		turnMap = new int[N][M];
		int cnt=0;
		for(int i=c+1; i<n; i++) {
			turnQ.add(map[i-1][c]);
		}
		for(int j=c+1; j<m; j++) {
			turnQ.add(map[n-1][j-1]);
		}
		for(int i=n-1; i>c; i--) {
			turnQ.add(map[i][m-1]);
		}
		for(int j=m-1; j>c; j--) {
			turnQ.add(map[c][j]);
		}
//		System.out.println(turnQ);
		for(int i=1; i<R; i++) {
			int x = turnQ.pollLast();
			turnQ.addFirst(x);
		}
		for(int i=c+1; i<n; i++) {
			map[i][c] = turnQ.poll();
		}
		for(int j=c+1; j<m; j++) {
			map[n-1][j] = turnQ.poll();
		}
		for(int i=n-1; i>c; i--) {
			map[i-1][m-1] = turnQ.poll();
		}
		for(int j=m-1; j>c; j--) {
			map[c][j-1] = turnQ.poll();
		}
		
		turn(n-1,m-1,c+1);
		
	}

}
