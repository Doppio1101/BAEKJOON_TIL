package week5.day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17074_2 {
	static BufferedReader br;
//	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] ary;
//	static int[][] ary2;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ary = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		//시간 초과와 메모리 초과로 인해 문제 분석...
		// 전체가 정렬이 되어있으면 N개 만큼의 새로운 정렬 된 배열이 생긴다.
		// 1개라도 뒤에보다 큰 숫자가 앞에 있으면 정렬을 할 수 있는 경우가 줄어든다.
		// 뒤에보다 큰 숫자가 두 군데이상이 나오면 정렬 된 배열이 있을 수 없다.
		// ex)21443, 221354 이렇듯 정렬에 어긋난 숫자가 2개 이상 나오면, 그 하나를 빼더라도 정렬이 안 되기때문에 정렬 된 배열을 만들 수 없다.
		int check = 0;
		int point = 0;
		int answer = 0;
		if (N == 2) {
			answer=2;
		} else {
			for (int i = 0; i < N - 1; i++) {
				if (ary[i] > ary[i + 1]) {
					point = i;
					check++;
				}
			} // 정렬에 어긋난 숫자의 위치를 파악하여, 경우의 수를 생각할 수 있다.
			if (check == 0) {//체크된 숫자가 없으면 정렬이 되어있으므로 어느 하나를 빼더라도 정렬 된 배열이 된다.
				answer=N;
			} else if (check == 1) {
				if(point ==0) {//0번에서 엇나갔으면, 1번보다 0번이 크다는 뜻.
					if(ary[0]<=ary[2]) {//0번에서 엇나갔고 2번이 0번보다 크거나 같으면,
						//어차피 check가 1이라는 것은 3번부터는 2번보다 크거나같은 숫자만 있다는 것
						//0번이 1번보다 큰 것이 되기 때문에, 0번이 빠질 때와 1번이 빠질 때 정렬 된 배열이 된다.
						answer = 2;
					}else {
						//0번이 2번보다 크다는 것은 0번이 빠질 때만 정렬 된 배열이 됨을 알 수 있다.
						answer = 1;
					}
				}
				else if (point == N - 2) {// 만약 엇나간 부분이 마지막에서 두번째라면,
					if (ary[point - 1] <= ary[point + 1]) {
						//위와 비슷하게, 뒤에서 두 번째가 빠질 때와 마지막이 빠질 때 정렬 된 배열이 된다.
						answer = 2;

					}else {
						//check가 1일 때, 뒤에서 두 번째는 뒤에서 세 번째보다 크다.
						//즉, 마지막 숫자가 뒤에서 세 번째 숫자보다 작다면, 
						//마지막 숫자때문에 정렬 된 배열을 만들 수 없었던 것으로, 마지막 숫자만 사라진다면 정렬 된 배열을 만들 수 있다.
						answer = 1;
					}

				}else {
					//어긋난 위치가 0번째도 아니고 뒤에서 두 번째도 아니면 중간 어디선가에서 어긋 남.
					//두 개는 서로 동시에 존재할 수 있다. ex)1515 
					if(ary[point-1]<=ary[point+1]) {
						//ex)1511
						answer++;
					}
					if(ary[point]<=ary[point+2]) {
						//ex)3515
						answer++;
					}
				}
			}

		}
		System.out.println(answer);
	}

}
