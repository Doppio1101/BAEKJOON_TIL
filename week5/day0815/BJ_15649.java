package week5.day0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();//
	static int[] ary;//1~N까지 넣을 배열
	static int N,M;//N은 1~N까지의 카드, M은 뽑을 카드의 개수
	static int[] answerAry;//M개의 카드를 넣을 배열
	static boolean[] isSelected;//N개의 카드가 선택됐는지 확인하는 배열
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");//한 줄로 들어온 정보를 " "를 
		N = Integer.parseInt(st.nextToken());//N을 입력.
		M = Integer.parseInt(st.nextToken());//M을 입력.
		
		ary = new int[N];//1~N까지 넣을 배열 ary의 크기를 설정
		answerAry = new int[M];//1~N 중 M개를 골라 넣을 배열 answerAry크기 설정.
		isSelected = new boolean[N];//N개의 카드 중 선택 된 카드가 있는지 확인하는 배열의 크기를 설정
		for(int i=0; i<N; i++) {//1~N까지의 숫자를 넣어주기 위한 for문
			ary[i] = i+1;//0~N-1번째에 1~N까지의 숫자 넣기.
		}
		pe(0);//순열시작.
		
		System.out.println(sb.toString());//저장했던 값 StringBuilder 출력
	}

	private static void pe(int cnt) {//초기값 0으로 시작 1씩 증가
		if(cnt==M) {//cnt가 M과 같아지면 StringBuilder에 저장.
			for(int i=0; i<M; i++) {//answerAry에 있는 값을 StringBuilder에 저장하기 위한 for문
				sb.append(answerAry[i]+" ");//answerAry의 i번째 값과 " "공백 문자를 넣어준다.
			}
			sb.append("\n");//개행문자를 StringBuilder에 넣어서 다음 값이 밑 줄에 출력되도록 함.
			return;//재귀함수를 끝내기 위한 기저조건
		}
		
		for(int i=0; i<N; i++) {//1~N까지의 숫자를 ary에서 i를 통해 가져온다.
			if(isSelected[i]) continue;//ary의 i번째 숫자가 선택 된 숫자라면 다음 숫자로 넘기기.
			
			answerAry[cnt] = ary[i];//answerAry의 cnt번째에 ary의 i번째 숫자 저장.
			isSelected[i]=true;//ary에서 뽑은 숫자의 위치를 true로 바꿔 줌으로 해서 재귀 호출 시에 중복된 값이 들어가지 않도록 변경
			pe(cnt+1);//재귀 호출
			isSelected[i]=false;//재귀 호출이 끝나고 나면 이전에 뽑았던 숫자의 위치를 false처리해서 다음 재귀 호출에서 사용할 수 있도록 변경해준다.
			
		}
		
		
	}

}
