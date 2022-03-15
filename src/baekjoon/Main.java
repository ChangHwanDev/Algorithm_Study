package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static boolean prime[];

	public static void main(String[] args) throws IOException {
		Scanner sc =new Scanner(System.in);
		int A[][] = new int [4][2];
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				A[i][j]= sc.nextInt();
			}
		}
		if(A[0][0] == A[1][0])
			A[3][0] =A[2][0];
		else if(A[0][0] == A[2][0])
			A[3][0]=A[1][0];
		else if(A[1][0] == A[2][0])
			A[3][0]=A[0][0];
		if(A[0][1] == A[1][1])
			A[3][1]=A[0][1];
		else if(A[0][1] == A[2][1])
			A[3][1]=A[1][1];
		else if(A[1][1] == A[2][1])
			A[3][1]=A[0][1];
		System.out.println(A[3][0]+" "+A[3][1]);
	}
}