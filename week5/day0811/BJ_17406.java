package week5.day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17406 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map;
	static int[][] turnMap;
	static int N,M,K;
	
	//순열 만드는 놈들
	static int[] number;
	static boolean[] isSelected;
	
	static int[][] info;
	static Queue<int[]> turnInfo;
	static Deque<Integer> turnQ;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		number = new int[K];
		isSelected = new boolean[K];
		info = new int[K][3];
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		turnInfo = new LinkedList<>();//new int[K][3];//(r,c)라는 중점과 거리 s
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine()," ");
			info[k][0] = Integer.parseInt(st.nextToken());
			info[k][1] = Integer.parseInt(st.nextToken());
			info[k][2] = Integer.parseInt(st.nextToken());
			
		}
		nPn(0);
		
		int min = Integer.MAX_VALUE;
		int kk = turnInfo.size();
		for(int cnt=0; cnt<kk; cnt++) {
			copy();
			int[] x=turnInfo.poll();
			for(int l=0; l<K; l++) {
				int r = info[x[l]][0];
				int c = info[x[l]][1];
				int s = info[x[l]][2];
				turn(r-1, c-1, s);
//				for(int[] arr : turnMap) {
//					System.out.println(Arrays.toString(arr));
//				}
//				System.out.println("=====");
			}
			min = Math.min(min,sumMap());
			
		}
		
		
		System.out.println(min);
	}
	
	static void nPn(int cnt) {
		if (cnt == K) { 
			
			int[] newAry = new int[number.length];
			for(int i=0; i<number.length; i++) {
				newAry[i] = number[i];
			}
			turnInfo.add(newAry);
			return;
		}

		for (int i = 0; i <K; i++) {
			if (isSelected[i])
				continue;
			
			number[cnt] = i;
			isSelected[i] = true;
			nPn(cnt + 1);
			isSelected[i] = false;

		}
		
	}
	

	private static int sumMap() {
		int min = Integer.MAX_VALUE;
		for(int n=0; n<N; n++) {
			int sum = 0;
			for(int m=0; m<M; m++) {
				sum += turnMap[n][m];
			}
			min = Math.min(min, sum);
		}
		
		return min;
	}

	private static void copy() {
		// TODO Auto-generated method stub
		turnMap = new int[N][M];
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				turnMap[n][m] = map[n][m];
			}
		}
	}

	private static void turn(int n, int m,int c) {
		// TODO Auto-generated method stub
		if(c==0) {
			return;
		}
		turnQ = new LinkedList<>();
		
		for(int j=m-c; j<m+c; j++) {
			turnQ.add(turnMap[n-c][j]);
		}//우
		for(int i=n-c; i<n+c; i++) {
			turnQ.add(turnMap[i][m+c]);
		}//하
		for(int j=m+c; j>m-c; j--) {
			turnQ.add(turnMap[n+c][j]);
		}//좌
		for(int i=n+c; i>n-c; i--) {
			turnQ.add(turnMap[i][m-c]);
		}//상
//		System.out.println(turnQ.toString());
		int x =turnQ.pollLast();
		turnQ.addFirst(x);
		for(int j=m-c; j<m+c; j++) {
			turnMap[n-c][j] = turnQ.pollFirst();
		}//우
		for(int i=n-c; i<n+c; i++) {
			turnMap[i][m+c] = turnQ.pollFirst();
		}//하
		for(int j=m+c; j>m-c; j--) {
			turnMap[n+c][j] = turnQ.pollFirst();
		}//좌
		for(int i=n+c; i>n-c; i--) {
			turnMap[i][m-c] = turnQ.pollFirst();
		}//상
		turn(n,m,c-1);
		
	}

}
