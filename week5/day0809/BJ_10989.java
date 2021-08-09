package week5.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10989 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] ary;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N=Integer.parseInt(br.readLine());
		ary = new int[N];
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ary);
		for(int a:ary) {
			sb.append(a).append("\n");
		}
		System.out.println(sb.toString());
	}

}
