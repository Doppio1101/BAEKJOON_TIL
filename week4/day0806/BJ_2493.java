package com.ssafy.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493 {

	public static Stack<Integer> stackA = new Stack<>();
	public static Stack<Integer> stackB = new Stack<>();
	public static Stack<Integer> stackAnswer = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int n=0; n<N; n++) {
			stackA.push(Integer.parseInt(st.nextToken()));
		}
		System.out.println(stackA.toString());
		for(int a=0; a<stackA.size(); a++) {
			int x=stackA.pop();
			System.out.println("Pop!"+x);
			System.out.println("stackA Now -> "+stackA.toString());
			while(true) {
				if(!stackA.empty())  {
					int y = stackA.pop();
					System.out.println("In Pop~!"+y);
					stackB.push(y);
					System.out.println("stackB Now -> "+stackB.toString());
					if(y>x) {
						stackAnswer.push(N-stackB.size());
						System.out.println("Answer Now => "+stackAnswer.toString());
						
						break;
					}else {
						continue;
					}
				}else {
					stackAnswer.push(0);
					break;
				}
			}
			for(int b=0; b<stackB.size(); b++) {
				int l = stackB.pop();
				stackA.push(l);
			}
			
			System.out.println("stack size A:"+stackA.size()+"   B"+stackB.size());
		}

		for(int i=0; i<stackAnswer.size(); i++) {
			int ans = stackAnswer.pop();
			sb.append(ans+" "+i);
		}
		System.out.println(sb.toString());
	}

}
