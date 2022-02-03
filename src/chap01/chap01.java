package chap01;

import java.util.Scanner;

public class chap01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			System.out.println("세 정수의 최대값을 구합니다");
			System.out.println("a의 값 : " ); int a = sc.nextInt();
			System.out.println("b의 값  : " ); int b = sc.nextInt();
			System.out.println("c의 값 : "); int c = sc.nextInt();
			int max = a;
			if (b > max) max = b;
			if (c > max) max = c;
			System.out.println("최대값은 " + max);
		int n,sum=0;
		n = sc.nextInt();
			//n이 7이면 1~7 덧셈
			for (int i =0; i<=n;i++) {
				sum += i;
			}System.out.println(sum);
	}

}
