package chap01;

import java.util.Scanner;

public class chap01_middle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
	int a,b,c;
	int mid;
	a = sc.nextInt();
	b = sc.nextInt();
	c = sc.nextInt();
	mid =0;
	if(a<b && b<c) mid = b;
	if(c > b && a < b) mid = b;
	if(c > b && b < a) mid = a;
	System.out.println(mid);
	}

}
