package com.ssafy.day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1158 {
	static Queue<Integer> q;
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	static int N,K;//N은 사람 수, K는 없애는 단위
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		q = new LinkedList<>();
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		int i=0;
		sb.append("<");
		while(i<N) {
			for(int j=1; j<=K; j++) {
				int x = q.poll();
				if(j==K) {
//					ary[i] = x;
					sb.append(x);
					i++;
					break;
				}else {
					q.add(x);
				}
			}
			if(i!=N) {
				sb.append(", ");
			}
		}
		//sb.deleteCharAt(sb.lastIndexOf(",")).deleteCharAt(sb.lastIndexOf(" ")).append(">");
		sb.append(">");
		System.out.println(sb.toString());
		
	}

}
