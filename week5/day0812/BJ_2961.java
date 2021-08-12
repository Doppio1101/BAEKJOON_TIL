package week5.day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2961 {

	static BufferedReader br;
	static StringTokenizer st;
	static int[][] kind;
	static int N;
	static int[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		kind = new int[N][2];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			kind[n][0] = Integer.parseInt(st.nextToken());
			kind[n][1] = Integer.parseInt(st.nextToken());
		}
		
		if (N == 1) {
			System.out.println(Math.abs(kind[0][1] - kind[0][0]));
		} else {
			int min = Integer.MAX_VALUE;
			
			check = new int[N * N][N];
			fill();
			for (int i = 1; i < N * N; i++) {
				int ms = 1;
				int mss = 0;
				for (int j = 0,l=N-1; j < N; j++) {
					if (check[i][l--] == 1) {
						ms *= kind[j][0];
						mss += kind[j][1];
					}
				}
				min = Math.min(min, Math.abs(mss - ms));
			}

			System.out.println(min);
		}
		for(int[] a:check) {
			System.out.println(Arrays.toString(a));
		}
	}

	private static void fill() {

		for (int i = 1; i < N * N; i++) {
			String str = Integer.toBinaryString(i);
//			System.out.println(str);
			for (int j = str.length() - 1, l = 0; j >= 0; j--) {
				check[i][N - 1 - j] = str.charAt(l++) - '0';
			}
		}

	}

}
