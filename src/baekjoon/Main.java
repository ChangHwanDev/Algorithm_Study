package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)  {
	long n = 123456789;
	String s = String.valueOf(n);
	
	StringBuilder sb = new StringBuilder(s);
	sb.reverse();
	String[] Arr = sb.toString().split("");
	int[] answer= new int[sb.length()];
	for(int i=0;i<sb.length();i++) {
		answer[i] = Integer.parseInt(Arr[i]);
	}
	}
}