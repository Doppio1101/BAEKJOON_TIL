package week2022_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3078_3try {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static Queue<Integer>[] QAry;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		QAry = new Queue[21];//20글자가 최대가 됨
		
		for(int n=0; n<21; n++) {
			QAry[n] = new LinkedList<Integer>();
		}
		int result = 0;
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			int nowSize = str.length();
			
			if(QAry[nowSize].isEmpty()) {
				//현재 확인 하는 학생과 친구가 될 수 있는 애가 없으면
				QAry[nowSize].add(n);
				//nowSize 자리에서 대기
			}else {
				//현재 확인하는 학생과 친구가 될 가능성이 있는 애가 있으면
				
				while(true) {
					if(n - QAry[nowSize].peek() > K ) {
						//만약 친구가 될 수 있는 애의 번호가 현재 학생의 번호 차이가 K보다 작아야 됨.
						// 학생 번호n - 친구가 될 수 있는 애의 번호 차이가 K보다 크면 서로 친구가 될 수 없음.
						QAry[nowSize].poll();
						if(QAry[nowSize].isEmpty()) {
							//근데 이렇게 빼다가 친구가 될 수 있는 애가 남아있지 않으면...
							break;
						}
						
					}else {
						//남아있는 애들은 친구가 될 수 있다는 것
						break;
					}
				}
				
				result += QAry[nowSize].size();
				QAry[nowSize].add(n);
				
			}			
			
		}
		System.out.println(result);
		
		
	}

}
