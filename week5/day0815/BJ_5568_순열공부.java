package week5.day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_5568_순열공부 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,K;//N장 중에서 K장을 골라 만드는 순열
	static String ary[];//N장을 넣을 배열
	static boolean isSelected[];
	static Set<String> answer;//중복을 거부.
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		ary = new String[N];
		for(int i=0; i<N; i++) {
			ary[i] = br.readLine();
		}
		//1, 2, 12, 1
		answer = new HashSet<>();
		isSelected = new boolean[N];
		pe(0,"");
		System.out.println(answer.size());
		
	}

	private static void pe(int cnt,String str) {
		if(cnt==K) {
			//여기 뭔가를 할 예정.
//			System.out.println(str);
			answer.add(str);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
	
			
			isSelected[i] = true;
			pe(cnt+1,str+ary[i]);
			isSelected[i] = false;
			
			
		}
	
		
	}

}
