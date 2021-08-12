package week5.day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16935 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map;
	static int N, M, R;
	static int[][] turnMap;
	static Deque<Integer> turnQ = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int r = 0; r < R; r++) {
			int rr = Integer.parseInt(st.nextToken());
			switch (rr) {
			case 1:
				upDownChange();
				break;
			case 2:
				leftRightChange();
				break;
			case 3:
				rightRotation();
				break;
			case 4:
				leftRotation();
				break;
			case 5:
				partRightRotation();
				break;
			case 6:
				partLeftRotation();
				break;
			}

		}
//		turn(N, M, 0);

		for (int[] a : map) {
			for (int b : a) {
				sb.append(b + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void partLeftRotation() {
//		turnQ = new LinkedList<>();
		int[][] copyAry = new int[N][M];
		int hn = N/2;
		int hm = M/2;
		
		for(int i=0; i<hn; i++) {
			for(int j=hm; j<M; j++) {
				turnQ.addLast(map[i][j]);
			}
		}//2
		for(int i=0; i<hn; i++) {
			for(int j=0; j<hm; j++) {
				copyAry[i][j] = turnQ.pollFirst();
			}
		}//1
		//2->1
		
		for(int i=0; i<hn; i++) {
			for(int j=0; j<hm; j++) {
				turnQ.addLast(map[i][j]);
			}
		}//1
		for(int i=hn; i<N; i++) {
			for(int j=0; j<hm; j++) {
				copyAry[i][j] = turnQ.pollFirst();
			}
		}//4
		//1->4
		
		for(int i=hn; i<N; i++) {
			for(int j=0; j<hm; j++) {
				turnQ.addLast(map[i][j]);
			}
		}//4
		for(int i=hn; i<N; i++) {
			for(int j=hm; j<M; j++) {
				copyAry[i][j] = turnQ.pollFirst();
				}
		}//3
		//4->3
		
		for(int i=hn; i<N; i++) {
			for(int j=hm; j<M; j++) {
				turnQ.addLast(map[i][j]);
			}
		}//3
		for(int i=0; i<hn; i++) {
			for(int j=hm; j<M; j++) {
				copyAry[i][j] = turnQ.pollFirst();
			}
		}//2
		//3->2
		map = copyAry;
		
	}

	private static void partRightRotation() {
//		turnQ = new LinkedList<>();
		int[][] copyAry = new int[N][M];
		int hn = N/2;
		int hm = M/2;
		for(int i=hn; i<N; i++) {
			for(int j=0; j<hm; j++) {
				turnQ.addLast(map[i][j]);
			}
		}//4
		for(int i=0; i<hn; i++) {
			for(int j=0; j<hm; j++) {
				copyAry[i][j] = turnQ.pollFirst();
			}
		}//1
		//4->1
		
		for(int i=hn; i<N; i++) {
			for(int j=hm; j<M; j++) {
				turnQ.addLast(map[i][j]);
			}
		}//3
		for(int i=hn; i<N; i++) {
			for(int j=0; j<hm; j++) {
				copyAry[i][j] = turnQ.pollFirst();
			}
		}//4
		//3->4
		
		for(int i=0; i<hn; i++) {
			for(int j=hm; j<M; j++) {
				turnQ.addLast(map[i][j]);
			}
		}//2
		for(int i=hn; i<N; i++) {
			for(int j=hm; j<M; j++) {
				copyAry[i][j] = turnQ.pollFirst();
				}
		}//3
		//2->3
		
		for(int i=0; i<hn; i++) {
			for(int j=0; j<hm; j++) {
				turnQ.addLast(map[i][j]);
			}
		}//1
		for(int i=0; i<hn; i++) {
			for(int j=hm; j<M; j++) {
				copyAry[i][j] = turnQ.pollFirst();
			}
		}//2
		//1->2
		
		
		
		
		map = copyAry;
	}

	private static void leftRotation() {
//		turnQ = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=M-1; j>=0; j--) {
				turnQ.addLast(map[i][j]);
			}
		}
		int temp = N;
		N = M;
		M = temp;
		int[][] copyAry = new int[N][M];
		for(int j=0; j<M; j++) {
			for(int i=0; i<N; i++) {
				copyAry[i][j] = turnQ.pollFirst();
			}
		}
		
		map = copyAry;
	}

	private static void rightRotation() {
//		turnQ = new LinkedList<>();
		
		for(int i=N-1; i>=0; i--) {
			for(int j=0; j<M; j++) {
				turnQ.addLast(map[i][j]);
			}
		}
		int temp = N;
		N = M;
		M = temp;
		int[][] copyAry = new int[N][M];
		for(int j=0; j<M; j++) {
			for(int i=0; i<N; i++) {
				copyAry[i][j] = turnQ.pollFirst();
			}
		}
		
		map = copyAry;
		
	}

	private static void leftRightChange() {
		int[][] copyAry = new int[N][M];
		for(int n=0; n<N; n++) {
			for(int m=0,j=M-1; m<M; m++) {
				copyAry[n][m] = map[n][j--];
			}
		}
		map = copyAry;
	}

	private static void upDownChange() {
		int[][] copyAry = new int[N][M];
		for(int n=0,i=N-1; n<N; n++) {
			for(int m=0; m<M; m++) {
				copyAry[n][m] = map[i][m];
			}
			i--;
		}
		map = copyAry;
		
		
	}

	private static void turn(int n, int m, int c) {
		// TODO Auto-generated method stub
		if (n == c || m == c || c == R) {
			return;
		}
		turnQ = new LinkedList<>();

//		turnMap = new int[N][M];
		int cnt = 0;
		for (int i = c + 1; i < n; i++) {
			turnQ.add(map[i - 1][c]);
		}
		for (int j = c + 1; j < m; j++) {
			turnQ.add(map[n - 1][j - 1]);
		}
		for (int i = n - 1; i > c; i--) {
			turnQ.add(map[i][m - 1]);
		}
		for (int j = m - 1; j > c; j--) {
			turnQ.add(map[c][j]);
		}
//		System.out.println(turnQ);
		for (int i = 1; i < R; i++) {
			int x = turnQ.pollLast();
			turnQ.addFirst(x);
		}
		for (int i = c + 1; i < n; i++) {
			map[i][c] = turnQ.poll();
		}
		for (int j = c + 1; j < m; j++) {
			map[n - 1][j] = turnQ.poll();
		}
		for (int i = n - 1; i > c; i--) {
			map[i - 1][m - 1] = turnQ.poll();
		}
		for (int j = m - 1; j > c; j--) {
			map[c][j - 1] = turnQ.poll();
		}

		turn(n - 1, m - 1, c + 1);

	}

}
