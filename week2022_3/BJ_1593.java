package week2022_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1593 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int g, s;
	static int[] alphabet;
	static int[] alphabetCnt;
	static String W, S;
	
	public static void main(String[] args) throws IOException {
		//1. S - g + 1번의 반복
		st = new StringTokenizer(br.readLine()," ");
		g = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		alphabet = new int[58];
		alphabetCnt = new int[58];
		int answer = 0;
		W = br.readLine();
		char[] extra = W.toCharArray();
		Arrays.sort(extra);
		for(int i=0; i<g; i++) {
			
			alphabet['z'-extra[i]]++; 
		}
		
		
		S = br.readLine();
		for(int i=0; i<g; i++) {
			
			alphabetCnt['z'-S.charAt(i)]++;
			
		}
		boolean flag = true;
		for(int i=0; i<g; i++) {
			
			if(alphabetCnt['z'-W.charAt(i)] != alphabet['z'-W.charAt(i)]) {
				flag = false;
				break;
			}
			
		}
		if(flag) {
			answer++;
		}
		point : for(int i=g; i<s; i++) {
//			int now = 'z'-S.charAt(i-g);
			int before = alphabetCnt['z'-S.charAt(i-g)];
			alphabetCnt['z'-S.charAt(i-g)]--;
			alphabetCnt['z' - S.charAt(i)]++;
			int after = alphabetCnt['z'-S.charAt(i-g)];
			if(before == after) {
				if(flag) {
					answer++;
				}else {
					continue;
				}
			}
			else {
				//abc
				//abcd
				for(int j=0; j<g; j++) {
					if(alphabetCnt['z'-W.charAt(j)] != alphabet['z'-W.charAt(j)]) {
						flag = false;
						continue point;
					}
					
				}
				flag = true;
				answer++;
				
			}
		}
		System.out.println(answer);

	}

}
