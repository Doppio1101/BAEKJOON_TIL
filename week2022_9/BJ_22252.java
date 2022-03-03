package week2022_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_22252 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Map<String, PriorityQueue<Integer>> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		map = new HashMap<String, PriorityQueue<Integer>>();
		long result = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int query = Integer.parseInt(st.nextToken());
			String Gorilla = st.nextToken();
			PriorityQueue<Integer> PQ = map.get(Gorilla);
			if(PQ == null) {
				PQ = new PriorityQueue<>(Collections.reverseOrder());
			}
			if(query == 1) {
				int k = Integer.parseInt(st.nextToken());
				for(int j=0; j<k; j++) {
					PQ.add(Integer.parseInt(st.nextToken()));
				}
				
			}else {
				int b = Integer.parseInt(st.nextToken());
				for(int j=0; j<b; j++) {
					if(!PQ.isEmpty()) {
									
						result += PQ.poll();
					}
				}
			}
			map.put(Gorilla, PQ);
			
		}
		System.out.println(result);
		
	}

}
