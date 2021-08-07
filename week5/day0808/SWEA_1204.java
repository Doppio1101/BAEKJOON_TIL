package week5.day0808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204 {

	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] ary;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("input_1204.txt"));
		br  = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			int n = Integer.parseInt(br.readLine());
			ary= new int[101];
			st  = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<1000; i++) {
				ary[Integer.parseInt(st.nextToken())]++;
			}
			int max = Integer.MIN_VALUE;
			int maxary = Integer.MIN_VALUE;
			for(int i=0; i<101; i++) {
				if(max<=ary[i]) {
					max = ary[i];
					maxary = i;
				}
			}
			sb.append("#"+n+" ").append(maxary).append("\n");
			
			
		}
		System.out.println(sb.toString());
	}

}
