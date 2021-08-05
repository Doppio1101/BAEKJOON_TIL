package com.ssafy.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] numAry = new int[N];//fix Data
		Stack<Integer> extra = new Stack<>();
//		int[] answer = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int n=0; n<N; n++) {
			numAry[n] = Integer.parseInt(st.nextToken());
		}
//		answer[0] = 0;
		for(int i=N-1; i>0; i--) {
			int x = numAry[i];
			int checkP = 0;
			for(int n=i-1; n>=0; n--) {
				if(numAry[n]>x) {
				
					checkP = n+1;
					break;
				}
			}
//			answer[i] = checkP;
			extra.push(checkP);
		}
		extra.push(0);
//		answer[0] = 0;
		while(!extra.empty()) {
			int x = extra.pop();
			sb.append(x+" ");
		}
//		for(int i=0; i<N; i++) {
//			sb.append(answer[i]+" ");
//		}
		
		System.out.println(sb.toString());
	}
	
}
