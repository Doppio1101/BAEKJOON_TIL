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
		QAry = new Queue[21];//20���ڰ� �ִ밡 ��
		
		for(int n=0; n<21; n++) {
			QAry[n] = new LinkedList<Integer>();
		}
		int result = 0;
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			int nowSize = str.length();
			
			if(QAry[nowSize].isEmpty()) {
				//���� Ȯ�� �ϴ� �л��� ģ���� �� �� �ִ� �ְ� ������
				QAry[nowSize].add(n);
				//nowSize �ڸ����� ���
			}else {
				//���� Ȯ���ϴ� �л��� ģ���� �� ���ɼ��� �ִ� �ְ� ������
				
				while(true) {
					if(n - QAry[nowSize].peek() > K ) {
						//���� ģ���� �� �� �ִ� ���� ��ȣ�� ���� �л��� ��ȣ ���̰� K���� �۾ƾ� ��.
						// �л� ��ȣn - ģ���� �� �� �ִ� ���� ��ȣ ���̰� K���� ũ�� ���� ģ���� �� �� ����.
						QAry[nowSize].poll();
						if(QAry[nowSize].isEmpty()) {
							//�ٵ� �̷��� ���ٰ� ģ���� �� �� �ִ� �ְ� �������� ������...
							break;
						}
						
					}else {
						//�����ִ� �ֵ��� ģ���� �� �� �ִٴ� ��
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
