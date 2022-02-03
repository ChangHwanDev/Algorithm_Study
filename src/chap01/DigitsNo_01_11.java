package chap01;

import java.util.Scanner;

public class DigitsNo_01_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
System.out.println("숫자를 입력하시오");	
int a,b,c;
a = sc.nextInt();
b= sc.nextInt();

int n = sc.nextInt();
int length = (int)(Math.log10(n)+1);
int max = (int)(Math.max(a,b));
System.out.println("자리수는 " + length + " max" + max);
	}

}
