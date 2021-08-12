package week5.day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2170 {

	static BufferedReader br;
	static StringTokenizer st;
	
	static Queue<int[]> aryQ;
	static int N;
	static int[][] ary;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ary = new int[N][2];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			ary[n][0] = Integer.parseInt(st.nextToken());
			ary[n][1] = Integer.parseInt(st.nextToken());
		}
		//x좌표로 정렬하기
		for(int i=0; i<N; i++) {
			int x=ary[i][0];
			int y=ary[i][1];
			if(x==0&&y==0) {
				continue;
			}
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				int x2= ary[j][0];
				int y2= ary[j][1];
				
				if(x2>=x&&y2<=y) {
					ary[j][0] = 0;
					ary[j][1] = 0;
				}else if(x2<x&&x<=y2&&y2<=y) {
					ary[j][0]=0;
					ary[j][1]=0;
					ary[i][0]=x2;
					
				}else if(x<=x2&&x2<=y&&y<y2) {
					ary[j][0]=0;
					ary[j][1]=0;
					ary[i][1]=y2;
					
				}
				System.out.println(ary[i][0]+":::"+ary[i][1]);
			}
		}
		int sum=0;
		for(int i=0; i<N; i++) {
			if(ary[i][0]==0&&ary[i][1]==0) continue;
			int x = ary[i][0];
			int y = ary[i][1];
			
			sum += y-x;
		}
		System.out.println(sum);
		
	}

}
