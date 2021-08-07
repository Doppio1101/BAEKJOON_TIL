package week5.day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2072 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int x = Integer.parseInt(br.readLine());
		for(int t=1; t<=x; t++) {
			st = new StringTokenizer(br.readLine());
			int sum=0;
			for(int i=0; i<10; i++) {
				int s = Integer.parseInt(st.nextToken());
				if(s%2!=0) {
					sum += s;
				}
			}
			sb.append("#"+t+" "+sum+"\n");
			
			
		}
		System.out.println(sb.toString());
	}

}
