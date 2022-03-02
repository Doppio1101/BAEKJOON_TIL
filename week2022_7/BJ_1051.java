package week2022_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1051 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int N,M,L;
	static int result;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Math.min(N, M);
		
		map = new int[N][M];
		result = 1;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				int now = str.charAt(j)-'0';
				map[i][j] = now;
			}
		}
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<M; j++) {
				int now = map[i][j];
				find(i,j,now);
				
			}
			
		}
		System.out.println(result);
		
	}
	private static void find(int i, int j, int now) {
		
		for(int l=1; l<L; l++){
			
			if(!isIn(i+l,j+l)) {
				return;
			}
			int right = map[i][j+l];
			int bottom = map[i+l][j];
			int cross = map[i+l][j+l];

			if(cross == now && right == now && bottom == now ) {
				
				result = Math.max(result, (l+1)*(l+1));
			}
			
		}
		
	}
	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}

}
