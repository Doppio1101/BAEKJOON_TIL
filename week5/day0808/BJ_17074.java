package week5.day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17074 {
	static BufferedReader br;
//	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] ary;
//	static int[][] ary2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ary = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		int[][] ary2 = new int[N][N-1];
		for(int i=0; i<N; i++) {
			for(int j=0,l=0; j<N; j++,l++) {
				if(i==j) {
					l--;
					continue;
				}
				ary2[i][l] = ary[j];
			}
		}
		int max = check(N,ary2);
		System.out.println(max);
	}
	private static int check(int n,int[][] ary2) {
		int[][] sortAry = new int[n][n-1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				sortAry[i][j] = ary2[i][j];
			}
			Arrays.sort(sortAry[i]);
		}
	
		int check = 0;
		
		for(int i=0; i<n; i++) {

			boolean flag = true;
			for(int j=0; j<sortAry[i].length; j++) {
//				System.out.print(extra[j]+":::"+ary2[i][j]);
				if(sortAry[i][j] != ary2[i][j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				check++;
			}
		}
		return check;
	}
	

}
