package week5.day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563 {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	static int[][] map;
	static int[][] ary;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ary = new int[N][2];
		map = new int[100][100];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			int ii = Integer.parseInt(st.nextToken());
			int jj = Integer.parseInt(st.nextToken());
			for(int i=ii; i<ii+10; i++) {
				for(int j=jj; j<jj+10; j++) {
					if(map[i][j]==0) {
						map[i][j] = 1;
					}
				}
			}
		}
		int sum=0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
		
		
		
	}

}
