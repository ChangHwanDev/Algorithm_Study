package Datastructure;

import java.util.Scanner;

public class EuclidGCD {

	static int gcd(int x, int y) {
		if (y==0)
			return x;
		else
			return gcd(y,x%y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수의 최대공약수를 구합니다.");
		int x = sc.nextInt(); int y = sc.nextInt();
		System.out.println(gcd(x,y));
	}
}
