package week16.day1202;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6146 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int x,y,n;//(x,y)신아의 위치, n웅덩이의 개수
	static int[][] dr = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		y = Integer.parseInt(st.nextToken())+500;
		x = Integer.parseInt(st.nextToken())+500;
		n = Integer.parseInt(st.nextToken());
		map = new int[1001][1001];//
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())+500;
			int c = Integer.parseInt(st.nextToken())+500;
			map[r][c]= -1;
		}
//		System.out.println(map[500][500]);
		bfs(500,500);
//		System.out.println(map[500][500]);
		for(int r=495; r<510; r++) {
			for(int c=495; c<510; c++) {
				System.out.print(map[r][c]+"\t");
			}
			System.out.println();
		}
		System.out.println(map[y][x]-1);
	}

	private static void bfs(int r, int c) {

		Queue<int[]> Q = new LinkedList<int[]>();
		Q.add(new int[] {r,c});
		map[r][c] = 1;
	
		while(!Q.isEmpty()) {
			int arr[] = Q.poll();
//			System.out.println(Arrays.toString(arr));
			for(int d=0; d<4; d++) {
				int nr = arr[0] + dr[d][0];
				int nc = arr[1] + dr[d][1];
				if(isIn(nr,nc) && map[nr][nc] == 0) {
					Q.add(new int[] {nr,nc});
//					System.out.println(map[arr[0]][arr[1]]);
					map[nr][nc] = map[arr[0]][arr[1]]+1;
					if(nr == y && nc == x) {
						return;
					}
				}
			}
			
		}
		
		
	}

	private static boolean isIn(int nr, int nc) {
		return 0<= nr && nr<1001 && 0<= nc && nc < 1001;
	}
}
