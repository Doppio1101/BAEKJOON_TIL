package week5.day0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2961 {

	static BufferedReader br;
	static StringTokenizer st;
	static int[][] kind;
	static int N;
//	static int[] check;
	static Queue<boolean[]> check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		kind = new int[N][2];
		check = new LinkedList<>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			kind[n][0] = Integer.parseInt(st.nextToken());
			kind[n][1] = Integer.parseInt(st.nextToken());
		}
			int min = Integer.MAX_VALUE;
			
			
			fill(N,new boolean[N]);
//			for(int i=0; i<N*N; i++) {
//				System.out.println(Arrays.toString(check.poll()));
//			}
			int x = check.size();
			for (int i = 0; i <x; i++) {
				int ms=1;
				int mss=0;
				boolean[] ch =  check.poll();
				boolean flag = false;
				for (int j = 0;j < N; j++) {
					
					if(ch[j]) {
						flag=true;
						ms = ms * kind[j][0];
						mss = mss + kind[j][1];
					}
				}
//				System.out.println(Arrays.toString(ch));
				if(flag) min = Math.min(min, Math.abs(mss - ms));
			}

			System.out.println(min);
		
		
	}

	private static void fill(int toCheck, boolean[] status) {
		if(toCheck==0) {
//			System.out.println(Arrays.toString(status));
			boolean[] tf = new boolean[N];
//			check.add(status);
			for(int i=0; i<N; i++) {
				tf[i] = status[i];
			}
			add(tf);
			return;
		}
		
		status[N-toCheck] = true;
		fill(toCheck-1,status);
		status[N-toCheck] = false;
		fill(toCheck-1,status);
		
	}

	private static void add(boolean[] status) {
		// TODO Auto-generated method stub
		check.add(status);
	}

}
