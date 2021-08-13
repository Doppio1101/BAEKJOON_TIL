package week5.day0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17135 {
	static BufferedReader br;//줄 단위로 입력 받기위한 버퍼드리더
	static StringTokenizer st;//줄 단위로 입력 받고 띄어쓰기를 기준으로 잘라쓰고자 StringTokenizer 선언
	static int N;//지도의 크기를 담을 정수 N
	static int M;//지도의 크기를 담을 정수 M
	static int D;//궁수의 사정거리
	static int R=3;//궁수는 3명으로 고정...
	static int[][] map; //지도를 담을 이차원 정수 배열.
	static List<int[]> enermy;
	static List<Enermy> enermyList;
	static int[] archer;//항상 N+1위치에 있다.=> map[N-1][???]
	static Queue<int[]> combiQ;
	static int answer;
	static int Max;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));//시스템으로 부터 입력을 받겠다.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken());		
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		enermy = new ArrayList<>();
		enermyList = new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					enermy.add(new int[] {i,j});
					enermyList.add(new Enermy(i, j));
				}
			}
		}
//		archer = new int[M];
		//mCr문제 길이 M에서 궁수 R명이 놓일 수 있는 조합.
		combiQ = new LinkedList<>();
		makeCombi();
		int x =combiQ.size();
		answer = Integer.MIN_VALUE;
		Max = Integer.MIN_VALUE;
//		for(int i=0; i<x; i++) {
//			System.out.println(Arrays.toString(combiQ.poll()));
//		}
		play(x);
		
		System.out.println(Max);
	}
	
	static class Enermy{
		public int r;//i좌표
		public int c;//j좌표
		public int d;//궁수와의 거리
		public boolean t;
		public Enermy(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			
		}
		public Enermy(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	
	private static void play(int Qsize) {
		Max = Integer.MIN_VALUE;
		for(int i=0; i<Qsize; i++) {
			deploy();
			answer = 0;
			while(!isEmptyEnermy()) {
				shoot();
				moveEnermy();
				
			}
			Max = Math.max(Max, answer);
		}
	}

	
	
	private static void deploy() {
		int[] de = combiQ.poll();
		archer = new int[3];
		int l=0;
		for(int j=0; j<de.length; j++) {
			if(de[j]==1) {
				map[N-1][j] = 7;//궁수 배치
				archer[l++] = j;
			}else {
				map[N-1][j] = 0;//궁수 자리 아닌 곳 0으로 바꿈.
			}
		}
		Sort();
			
	}
	
	private static void Sort() {
		for(int i=0; i<enermyList.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<3; j++) {
				int w = Math.abs(enermyList.get(i).r-(N-1)) + Math.abs(enermyList.get(i).c-archer[j]); 
				min = Math.min(min, w);
			}
			enermyList.get(i).d = min;
		}
		Comparator<Enermy> myComparator = new Comparator<Enermy>() {
			  @Override
			  public int compare(Enermy p1, Enermy p2) {
				  if (p1.d > p2.d) {
				      return 1; // 거리에 대해서 오름차순
				    }
				    else if (p1.d == p2.d) {
				      if (p1.c > p2.c) { // c(j)에 대해서 오름차순
				        return 1;
				      }
				    }
				    return -1;
			  }
		};
		Collections.sort(enermyList, myComparator);
	}

	private static void shoot() {
		int x = enermyList.size();
//		for(int i=0; i<x; i++) {
//			for(int j=0; j<3; j++) {
//				if(enermyList.get(i).d <= D) {
//					enermyList.get(i).t = true;
//				}
//			}
//			if(enermyList.get(i).t) {
//				enermyList.remove(i);
//				answer++;
//			}
//		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<x; j++) {
				if(enermyList.get(j).d<= D) {
					enermyList.get(j).t = true;
					break;
				}
			}
			
		}
		for(int i=0; i<enermyList.size(); i++) {
			if(enermyList.get(i).t) {
				answer++;
				enermyList.remove(i--);
			}
		}
	}

	private static boolean isEmptyEnermy() {
		boolean flag = true;
//		check: for(int i=0; i<N-1; i++) {
//			for(int j=0; j<M; j++) {
//				if(map[i][j]==1) {
//					flag=false;
//					break check;
//				}
//			}
//		}
		if(enermyList.size()==0) {
			flag=true;
		}
		
		return flag;
	}

	private static void moveEnermy() {
//		for(int i=N-2; i>=0; i--) {
//			for(int j=0; j<M; j++) {
//				if(map[i][j]==1) {
//					if(i==N-2) {
//						map[i][j]=0;
//					}else {
//						map[i+1][j]=1;
//						map[i][j]=0;
//								
//					}
//				}
//			}
//		}
		for(int i=0; i<enermyList.size(); i++) {
			if(enermyList.get(i).r == N-2) {
				enermyList.remove(i);
			}
			enermyList.get(i).r -= 1; 
		}
		Sort();
	}
	
	private static void makeCombi() {
		// TODO Auto-generated method stub
		int[] p = new int[M];
		// 뒤쪽부터 R개만큼 1채우기
		int cnt = 0;
//		System.out.println(L+":::::"+M);
		while(++cnt<=R) p[M-cnt] = 1;
		
		do {
			// 조합사용
			int[] copy = new int[M];
			for(int i=0; i<M; i++) {
				copy[i] = p[i];
			}
			combiQ.add(copy);
			
		}while(np(p));
	}
	
	// 다음 큰 순열이 있으면 true, 없으면  false
	private static boolean np(int[] numbers) {
		
		int N = numbers.length;
		
		// step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false;
		
		// step2. i-1 위치값과 교환할 큰 값 찾기
		int j = N-1;		
		while(numbers[i-1]>=numbers[j]) --j;
		
		// step3. i-1위치값과 j위치값 교환 
		swap(numbers,i-1,j);
		
		// step4. 꼭대기(i)부터 맨뒤 까지 내림차순형태의 순열을 오름차순으로 처리
		int k = N-1;
		while(i<k) {
			swap(numbers,i++,k--);
		}
		
		return true;
	}
	
	private static void swap(int[] numbers,int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	

}
