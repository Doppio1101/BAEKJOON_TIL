package week2022_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_1983_D2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	static int N, K;
	static PriorityQueue<Student> PQ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			PQ = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int slice = N/10;
			for(int n=1; n<=N; n++) {
				st = new StringTokenizer(br.readLine()," ");
				int mid = Integer.parseInt(st.nextToken());
				int fin = Integer.parseInt(st.nextToken());
				int sub = Integer.parseInt(st.nextToken());
				Student s = new Student(n, mid, fin, sub);
				PQ.add(s);
			}
			int g = 0;//grade
			for(int n=1; n<=N; n++) {
				Student s = PQ.poll();
				if(s.n == K) {
					sb.append("#"+t+" "+grade[g]+"\n");
					break;
				}
				if(n%slice == 0) {
					g++;
				}
			}
			
			
			
		}
		System.out.println(sb.toString());
		
		
	}
	
	static class Student implements Comparable<Student>{
		
		int n;
		double score;

		public Student(int n, int mid, int fin, int sub) {
			super();
			this.n = n;
			this.score = (mid*0.35) + (fin*0.45) + (sub*0.2);
			
		}

		
		
		@Override
		public String toString() {
			return "Student [n=" + n + ", score=" + score + "]";
		}



		@Override
		public int compareTo(Student o) {
			return Double.compare(this.score, o.score) * -1;
		}
		
		
		
	}
	
}
