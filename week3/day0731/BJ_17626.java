package week3.day0731;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_17626 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> ary = new ArrayList<>();
		
		int x = sc.nextInt();
		int y = x;
		int sqrt=0;
		while(y!=0) {
			sqrt = (int)Math.sqrt(y);
			int ans = y - sqrt*sqrt;
			ary.add(sqrt);
			y = ans;
		}
		
		System.out.println(ary.toString());
		//System.out.println(ary1.toString());
	
	}

}
