package com.ssafy.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
//		int[] numAry = new int[N];//fix Data
		Stack<int[]> extra = new Stack<>();//이게 들어가지네..
		int[] answer = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int n=0; n<N; n++) {
			int x = Integer.parseInt(st.nextToken());
			if(extra.empty()) {
				extra.push(new int[] {n+1,x});
			}else {
				while(x>extra.peek()[1]) {
					extra.pop();
					if(extra.empty()) {
						break;
					}
				}
				if(!extra.empty()) {
					answer[n]=extra.peek()[0];
				}
				
				extra.push(new int[] {n+1,x});
			}
		}

		for(int n=0; n<N; n++) {
			sb.append(answer[n]+" ");
		}
		System.out.println(sb.toString());
	}
	
}
