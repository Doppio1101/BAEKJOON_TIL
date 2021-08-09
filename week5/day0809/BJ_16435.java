package week5.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16435 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] fAry;//과일이 들어갈 배열.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine()," ");
		int f = Integer.parseInt(st.nextToken());
		fAry = new int[f];
		int snake = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<f; i++) {
			fAry[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fAry);
		for(int i=0; i<f; i++) {
			if(fAry[i]<=snake) {
				snake++;
			}
		}
		System.out.println(snake);
	}

}
