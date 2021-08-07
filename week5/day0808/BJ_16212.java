package week5.day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16212 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] ary;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(br.readLine());
		ary = new int[N];
		st= new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ary);
		for(int i=0; i<N; i++) {
			sb.append(ary[i]+" ");
		}
		System.out.println(sb.toString());
	}

}
