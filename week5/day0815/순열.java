package week5.day0815;

import java.util.Arrays;

public class 순열 {
	static int N = 3, R = 3; // nPr nPn -> n!
	//{1,2,3} != {2,1,3}
	static int[] number;
	static boolean[] isSelected;
	
	public static void main(String[] args) {

		number = new int[R];//뽑을 카드의 개수
		isSelected = new boolean[N + 1];//뽑을 수 있는 카드의 개수
		//{1, 2, 3, 4}
		permutation(0);
		System.out.println("끝");

	}

	static void permutation(int cnt) {
		if (cnt == R) {//기저조건!
			print(number);
			return;
		}

		// 가능한 모든 수 시도
		for (int i = 1; i <= N; i++) {
			if (isSelected[i])
				continue; // 사용중이면 다음 수

			number[cnt] = i;
			isSelected[i] = true;

			// 다음 자리 순열로 고고
			permutation(cnt + 1);//cnt+1 =2;
			isSelected[i] = false;

		}

	}

	private static void print(int[] number2) {
		
		System.out.println(Arrays.toString(number2));
	}

}
