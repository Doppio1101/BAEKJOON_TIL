package week4.day0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10799{
	public static Stack<Character> stack;
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		N = Integer.parseInt(br.readLine());
//		for(int n=1; n<=N; n++) {
			stack = new Stack<>();	
			String str = br.readLine();
			
//			int i=1;
			int ans=0;
//			while(i!=str.length()) {
//				if(str.charAt(i)=='(') {
//					stack.push(str.charAt(i));
//					i++;
//					continue;
//				}else if(str.charAt(i)==')') {
//					if(str.charAt(i-1)==')') {
//						ans++;
//					}
//					else if(stack.peek()=='(') {
//						stack.pop();
//						ans = ans + stack.size();
//					} 
//					i++;
//					continue;
//				}
//				
//			}
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='(') {
					stack.push(str.charAt(i));
					continue;
				}else {
					if(str.charAt(i-1)=='(') {
						stack.pop();
						ans = ans + stack.size();
					}else {
						stack.pop();
						ans++;
					}
				}
			}
//			sb.append("#"+n+" "+ans+"\n");
//			
//		}
//		System.out.println(sb.toString());
		System.out.println(ans);
	}
	
}
