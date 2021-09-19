package week10.day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1767 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			int result=0;
			
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb.toString());
	}
}
