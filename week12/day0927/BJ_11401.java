package week12.day0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11401 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] DP;
	static long mod = 1000000007;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		DP = new long[N+1];
		DP[0] = 1;
		DP[1] = 1;
		System.out.println(pow(2,8));
		long result = ((fact(N)%mod)*(pow(fact(N-K)*fact(K),mod-2)%mod))%mod;
		System.out.println(result);
	}

	private static long fact(int n) {
		if(DP[n]!=0) {
			return DP[n];
		}
		return DP[n] = ((fact(n-1)%mod) * (n%mod))%mod;
	}
	private static long pow(long num, long mod2) {
		if(mod2 == 0) {
			return 1;
		}
		else {
			long temp = pow(num,mod2/2);
			if(mod2%2 == 0) {
				//2^4 = 2^2 * 2^2
				return temp * temp;
			}else {
				//2^5 = 2^2 * 2^2 * 2
				return temp * temp*num;
			}
		}
	}

}
