package chap01;

public class chap01_good {
	static int max(int a, int b, int c) {
		int max= a;
		if ( b > max)
			max = b;
		if ( c> max)
			max =c;
	return max;
}
	static int max4(int a, int b, int c, int d)
	{	int max = a;
	if ( b > max)
		max= b;
	if(c > max)
		max = c;
	if(d > max)
		max = d;
	return max;}
	
	static int min(int a ,int b , int c , int d) {
		int min=a;
		if(min > b) min = b;
		if(min > c ) min = c;
		if(min > d) min = d;
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(max(3,2,1));
	System.out.println(max4(8,5,6,7));
	System.out.println(min(6,3,2,4));
	}
}
