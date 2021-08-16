package week5.day0815;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 조합 {
	static int N = 3, R = 3;
	static int[] number;
	static boolean[] isSelected;
	static char[] src = {'a', 'b', 'c', 'd'};//abcd 중 3개를 뽑는 조합
	//nCr == nCn-r
	public static void main(String[] args) {

		number = new int[R];
		isSelected = new boolean[N + 1];
		//4P3 => 24개
		
		//4P3에서 중복을 제거 한 경우의 수4C3 => 4개
		
		System.out.println("조합");
        makeCombination(3,new char[3], 0);


	}

	static void makeCombination(int toChoose, char [] choosed, int startIdx) {
        if(toChoose==0) {
            System.out.println(Arrays.toString(choosed));
            return;
        }
        for(int i=startIdx; i<src.length; i++) {
            choosed[choosed.length/*3으로 고정*/-toChoose/*3부터 1씩 내려가는 변수*/] = src[i];//맨처음, 리스트에 0번째 값을 넣음.
            makeCombination(toChoose-1, choosed, i+1);
        }
    }

}
