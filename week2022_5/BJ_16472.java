package week2022_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BJ_16472 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char[] strAry = str.toCharArray();
		int size = str.length();
		char[] firstAlpha = new char[26];
		char[] lastAlpha = new char[26];
		int first = 0;
		int last = strAry.length-1;
		//System.out.println(last);
		int firstCnt = 0;
		int lastCnt = 0;
		
		Map<Character, Integer> firstMap = new HashMap<>();
		Map<Character, Integer> lastMap = new HashMap<>();
		Queue<Character> firstQ = new LinkedList<>();
		Queue<Character> lastQ = new LinkedList<>();
		
		int result = 0;
		
		while(first < size ) {
			
			char firstChar = strAry[first++];
			firstAlpha[firstChar-'a']++;
			firstCnt++;
			if(firstMap.containsKey(firstChar)) {
				int cnt = firstMap.get(firstChar);
				firstMap.put(firstChar, cnt+1);
			}else {
				firstMap.put(firstChar, 1);
				firstQ.add(firstChar);
				if(firstQ.size()>N) {
					int cnt = firstAlpha[firstQ.poll()-'a'];
					result = Math.max(result, firstCnt-1);
					firstCnt = firstCnt - cnt;
					firstMap.remove(firstChar);
				}
			}
			
			/*
			char lastChar = strAry[last];
			lastAlpha[lastChar-'a']++;
			lastCnt++;
			if(lastMap.containsKey(lastChar)) {
				int cnt = firstMap.get(lastChar);
				lastMap.put(lastChar, cnt+1);
			}else {
				lastMap.put(lastChar, 1);
				lastQ.add(lastChar);
			}
			
			
			if(lastMap.size()>N) {
				int cnt = lastAlpha[lastQ.poll()-'a'];
				result = Math.max(result, lastCnt-1);
				lastCnt = lastCnt - cnt;
				lastMap.remove(lastChar);
			}
			*/
			//first++;
			last--;
		}
		result = Math.max(result, firstCnt);
		result = Math.max(result, lastCnt);
		
		System.out.println(result);
	}

}
