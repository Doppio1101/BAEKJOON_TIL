package week6.day0816;

import java.util.Arrays;

public class 조합 {
	static int N = 4, R = 3; // nCr
	static int[] answer;
	static int[] number;
//	static boolean[] isSelected;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		answer = new int[R];
		number = new int[N];
		for(int i=1; i<=N; i++) {
			number[i-1] = i*2;
		}
//		System.out.println(Arrays.toString(number));
		
		combi(0,0);//뽑을 개수의 시작지점, 가져올 숫자의 시작지점
		System.out.println("끝");

	}

	private static void combi(int cnt,int idx) {//cnt는 뽑은 개수, idx는 시작하는 위치
		if(cnt==R) {
			//뭔가를 할 예정.
			System.out.println(Arrays.toString(answer));
			return;
		}
		for(int i=idx; i<N; i++) {
			answer[cnt] = number[i];
			combi(cnt+1,i+1);
		}

	}

}
