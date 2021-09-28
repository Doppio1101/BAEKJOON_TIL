package week12.day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long M,N;//M은 사용한 종류 개수, N은 비밀번호 길이
	//M개의 자판으로 N자리 비밀번호
	static long result;
	static long MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			result=0;
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken())%MOD;
			N = Integer.parseInt(st.nextToken())%MOD;
			
			
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
	}
}
