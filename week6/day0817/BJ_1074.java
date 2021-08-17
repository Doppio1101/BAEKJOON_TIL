package week6.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,R,C;
	static int copyN;
	static long find;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());		
		C = Integer.parseInt(st.nextToken());
		if(R==0&&C==0) {
			System.out.println("1");
		}else {
			copyN = N;
			find = 1;
			halfNhalf(R, C);//(0,0)에서 시작
		}
	}
	private static void halfNhalf(int i, int j) {
		int MaxI = (int) Math.pow(2,N)/2;//사등분 했을 때 오른쪽 아래를 가리킴
		int MaxJ = (int) Math.pow(2,N)/2;//사등분 했을 때 오른쪽 아래를 가리킴
		while(true) {
			if(MaxI<i&&MaxJ<j) {//현재 위치
				
			}else if(MaxI>i&&MaxJ<=j) {//위로
				find = find + (MaxI - MaxI/2)+(MaxJ - MaxJ/2);
				MaxI = MaxI - MaxI/2;
				MaxJ = MaxJ + MaxJ/2;
			}else if(MaxI<=i&&MaxJ>j) {//왼쪽으로
				MaxI = MaxI + MaxI/2;
				MaxJ = MaxJ - MaxJ/2;
			}else if(MaxI>i&&MaxJ>j) {//왼쪽 위
				MaxI = MaxI/2;
				MaxJ = MaxJ/2;
			}
		}
		
	}

}
