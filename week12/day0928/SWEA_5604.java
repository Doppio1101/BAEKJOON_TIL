package week12.day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5604 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long A,B;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			long result=0;
			st = new StringTokenizer(br.readLine()," ");
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			result = sum(B) - sum(A-1);
			
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb.toString());
	}

	private static long sum(long n) {
		if(n<= 0) return 0;
		long[] ary = new long[10];
		long s=1, sum=0, t, r;
		while(n>0) {
			t = n/(s*10);
			r = n % (s*10);
			for(int i=0; i<10; i++) {
				ary[i] +=t*s;
			}
			for(int i=1; i<=r/s; i++) {
				ary[i] += s;
			}
			ary[(int) ((r/s+1)%10)] += r % s;
			n -= 9*s;
			s *= 10;
		}
		for(int i=1; i<10; i++) {
			sum += i *ary[i];
		}
		
		
		return sum;
	}
}
