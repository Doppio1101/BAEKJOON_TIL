package week7.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class BJ_1753_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int V, E;
	static int Start;
	static ArrayList<Map<Integer,Integer>> graph;
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Start = Integer.parseInt(br.readLine());
		graph = new ArrayList<Map<Integer,Integer>>();
		for(int i=0; i<=V; i++) {
			graph.add(new Map<Integer, Integer>());
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.
		}
		
	}

}
