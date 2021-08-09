package week5.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10815 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] ary1;
	static int N;
	static int M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		ary1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			ary1[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(ary1);
		//이분탐색.. 나눠서 왼쪽 비교 후 오른쪽 비교
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken()); 
			if(check(a)) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb.toString());
		
	}
	private static boolean check(int a) {
		// TODO Auto-generated method stub
		int l =0;//1씩 증가
		int r =N-1;//1씩 감소
		while(l<=r) {//끝나는 조건은 다 뒤졌는데도 없을 때. r이 l보다 작아지면 l이 r보다 커지면 끝나겠다.
			int m = (l+r)/2;//반복할 때마다 중간을 찾는다.
			int mm = ary1[m];//중간 값을 확인
			//□□□□■□□□□□
			if(mm>a) {//중간값 mm이 a보다 크면 오른쪽 끝 라인이 더 작아저도 된다는 뜻. => 비교 범위를 왼쪽으로 좁혀도 된다.
				// ■값이 비교 대상 a보다 큰 위치에 있으면 l~■-1  위치만 보면 된다.
				r = m-1;
			}else if(mm<a) {//중간값 mm이 a보다 작으면 비교하는 범위가 오른쪽으로 좁혀저도 된다.
				// ■값이 비교 대상 a보다 작은 위치에 있으면 ■+1~r  위치만 보면 된다.
				l = m+1;
			}else {
				//같을 때가 되겠다.
				return true;
			}
			
		}
		
		return false;
	}

}
