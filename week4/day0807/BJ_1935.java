package week4.day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1935 {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	static char[] calAry;
	static double[] numAry;
	static Stack<Double> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		calAry = str.toCharArray();
		numAry = new double[n];
		stack = new Stack<>();
		for(int i=0; i<n; i++) {
			numAry[i] = Double.parseDouble(br.readLine());
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<calAry.length; j++) {
				if(calAry[j]-'A'==i) {
					calAry[j] = (char) (numAry[i]+'0');
				}
			}
		}//캐릭터 배열에 A일 때 첫번째 값.. 이렇게 넣음
		for(int i=0; i<calAry.length; i++) {
			if(calAry[i]=='+') {
				double y = stack.pop();
				double x = stack.pop();
				stack.push(x+y);
			}else if(calAry[i]=='-') {
				double y = stack.pop();
				double x = stack.pop();
				stack.push(x-y);
			}else if(calAry[i]=='/') {
				double y = stack.pop();
				double x = stack.pop();
				stack.push(x/y);
			}else if(calAry[i]=='*') {
				double y = stack.pop();
				double x = stack.pop();
				stack.push(x*y);
			}else {
				stack.push((double) (calAry[i]-'0'));
			}
		}
		System.out.printf("%.2f",stack.peek());
	}

}
