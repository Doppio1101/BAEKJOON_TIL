package week4.day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_review {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Stack<Tower> stack = new Stack<>();
		for(int i=1; i<=N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek().getHeight() <height) {
					stack.pop();
				}else {
					break;
				}
			}
			if(stack.isEmpty()) {
				sb.append("0 ");
			}else {
				sb.append(stack.peek().idx).append(" ");
			}
			stack.push(new Tower(height,i));
		}
		System.out.println(sb.toString());
		
	}

	static class Tower{
		int height;
		int idx;
		
		public Tower(int height, int idx) {
			super();
			this.height = height;
			this.idx = idx;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		
	}
	
}

