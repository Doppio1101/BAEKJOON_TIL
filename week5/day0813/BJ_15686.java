package week5.day0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_15686 {
	
	static BufferedReader br;//줄 단위로 입력 받기위한 버퍼드리더
	static StringTokenizer st;//줄 단위로 입력 받고 띄어쓰기를 기준으로 잘라쓰고자 StringTokenizer 선언
	static int N;//지도의 크기를 담을 정수 N
	static int M;//폐업시키지 않을 치킨집 수 M
	static int L;//입력받은 치킨집 수
	static int[][] map; //지도를 담을 이차원 정수 배열.
	static int[][] copyMap; //지도를 담을 이차원 정수 배열.
	static int[][] chicken;//0,1,2,3,4... [i,j]
	static Queue<int[]> combiQ;
	static int min;
	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));//시스템으로 부터 입력을 받겠다.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];//지도를 담을 이차원 배열을 N*N으로 초기화 한다.
		chicken = new int[13][2];//최대 13개의 치킨집이 입력된다
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");//br로 줄 단위 입력 후 st에 저장.
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());//맵이라는 이차원 배열을 0,1,2로 채워나감.
				if(map[i][j]==2) {//입력 받은 값이 2라면 해당 좌표를 따로 저장.
					chicken[L][0]=i;//chicken[L]번째 0에 i저장
					chicken[L++][1]=j;//chicken[L]번째 1에 j저장 후 L증가.
				}
			}// 줄 단위 입력으로 받은 토큰을 정수형으로 변환하여 저장
			
		}//br로 줄 단위 입력 후 st에 저장.
		combiQ = new LinkedList<>();
		makeCombi();

		check();
		System.out.println(min);
		
	}//main메소드 끝

	private static void check() {
		int s = combiQ.size();
		min = Integer.MAX_VALUE;
		for(int r=0; r<s; r++) {
			copyMap = new int[N][N];
			copy();
			int sum=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(copyMap[i][j]==1) {
						sum = sum + find(i,j);
					}
				}
			}
			min = Math.min(min, sum);
		}
	}

	private static int find(int i, int j) {
		int w=Integer.MAX_VALUE;
		
		for(int i2=0; i2<N; i2++) {
			for(int j2=0; j2<N; j2++) {
				if(copyMap[i2][j2]==2) {
					int l = Math.abs(i2-i)+Math.abs(j2-j);
					w = Math.min(w, l);
				}
			}
		}
		
		return w;
	}

	private static void copy() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copyMap[i][j]=map[i][j];
			}
		}
		int[] a = combiQ.poll();
		for(int i=0; i<a.length; i++){
			if(a[i]==0) {
				int x=chicken[i][0];
				int y=chicken[i][1];
				copyMap[x][y]=0;
			}
		}
	}

	private static void makeCombi() {
		// TODO Auto-generated method stub
		int[] p = new int[L];
		// 뒤쪽부터 R개만큼 1채우기
		int cnt = 0;
//		System.out.println(L+":::::"+M);
		while(++cnt<=M) p[L-cnt] = 1;
		
		do {
			// 조합사용
			int[] copy = new int[L];
			for(int i=0; i<L; i++) {
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

}//클래스 끝
