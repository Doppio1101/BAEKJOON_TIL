package week2022_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3078_Integer {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static Queue<Integer>[] QAry;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		QAry = new Queue[N];
		
		for(int n=0; n<N; n++) {
			QAry[n] = new LinkedList<Integer>();
		}
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			for(int i=0; i<=n; i++) {
				QAry[i].add(str.length());
			}
		}
		int result = 0;
		for(int i=0; i<N; i++) {
			
			int nowSize = QAry[i].poll();
			
			int k = 1;
			while(!QAry[i].isEmpty() && k++ <= K){
				int next = QAry[i].poll();
				if(next == nowSize) {
					result++;
				}
			}
			
			
		}
		System.out.println(result);
		
		
	}

}
