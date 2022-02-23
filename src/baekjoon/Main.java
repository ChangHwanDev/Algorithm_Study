package baekjoon;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Random ran = new Random();
		for(int i=0;i<7;i++) {
			System.out.println(ran.nextInt(47));
		}
	}
}
