package week4.day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1003 {
	static BufferedReader br;
	static StringBuilder sb;
	static int[][] ary = new int[41][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ary[0][0] = 1;//fibo(0)일 때 0개수
		ary[0][1] = 0;//fibo(0)일 때 1개수
		ary[1][0] = 0;//fibo(1)일 때 0개수
		ary[1][1] = 1;//fibo(1)일 때 1개수
		
		for(int tc=0; tc<N; tc++) {
			
			int x = Integer.parseInt(br.readLine());
			fibo(x);
			
			sb.append(ary[x][0]+" "+ary[x][1]+"\n");
		}
		System.out.println(sb.toString());
	}
	private static int[] fibo(int n) {
		if(n==0||n==1) {
			return ary[n];
		}
		if(ary[n][0]==0||ary[n][1]==0) {
			ary[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
			ary[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
		}
		return ary[n];
	}

}
