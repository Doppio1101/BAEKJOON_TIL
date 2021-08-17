package week4.day0806;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_1 {

//	public static Stack<Integer> stackA = new Stack<>();//처음입력받는 곳
//	public static Stack<Integer> stackB = new Stack<>();//임시저장소
//	public static Stack<Integer> stackAnswer = new Stack<>();//정답스택
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] answerlist = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> stackA = new Stack<>();
		Stack<Integer> stackB = new Stack<>();
		for(int n=0; n<N; n++) {
			stackA.push(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<N; i++) {
			int A = stackA.pop();
			int j=i;
			while(true) {
				j++;
				if(!stackA.empty()) {
					int Ans = stackA.pop();
					stackB.push(Ans);
					if(Ans>A) {
//						stackAnswer.push(N-j);
//						list.add(N-j);
						answerlist[i]=N-j;
						break;
					}else {
						continue;
					}
				}else {
//					list.add(0);
					answerlist[i]=0;
//					stackAnswer.push(0);
					break;
				}
			}while(stackB.size()!=0) {
				int e = stackB.pop();
				stackA.push(e);
			}
			
		}
		for(int i=N-1; i>=0; i--) {
//			int x = stackAnswer.pop();
			sb.append(answerlist[i]+" ");
		}
		System.out.println(sb.toString());
	}

}
