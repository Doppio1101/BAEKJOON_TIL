package week5.day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3040 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] fake = new int[9];
		int sum =0;
		for(int i=0; i<9; i++) {
			fake[i]=Integer.parseInt(br.readLine()); //sc.nextInt();
			sum += fake[i];
		}
		Arrays.sort(fake);
			ch : for(int j=1; j<5; j++) {
				for(int i=0; i<9; i++) {
					int a = i + j;
					if(a>8) {
						a = (a+1)%10;
					}
					
					if((sum-(fake[i]+fake[a])) == 100) {
						fake[i] =0;
						fake[a]=0;
						break ch;
					}
				}
			}
		
		for(int i=0; i<9; i++) {
			if(fake[i]!=0) {
				System.out.println(fake[i]);
			}
		}
	}

}
