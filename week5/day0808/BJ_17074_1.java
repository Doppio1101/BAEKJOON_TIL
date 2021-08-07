package week5.day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17074_1 {
	static BufferedReader br;
//	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] ary;
//	static int[][] ary2;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br  = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ary = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		int[] ary2 = new int[N-1];
		int max=0;
		for(int i=0; i<N; i++) {
			for(int j=0,l=0; j<N; j++,l++) {
				if(i==j) {
					l--;
					continue;
				}
				ary2[l] = ary[j];
			}
			max = max+check(ary2);
		}
		System.out.println(max);
	}
	private static int check(int[] ary2) {
		int check=0;
		int[] sortAry = new int[N-1];
		for(int i=0; i<N-1; i++) {
			sortAry[i] = ary2[i];
		}
		Arrays.sort(sortAry);
		boolean flag = true;
		for(int i=0; i<N-1; i++) {
			if(sortAry[i] != ary2[i]) {
				flag = false;
				break;
			}
		}
		if(flag) {
			check++;
		}
		return check;
	}
	

}
