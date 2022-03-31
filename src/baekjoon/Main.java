package baekjoon;



public class Main {

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		String[] srr = s.toLowerCase().split("");
		String answer="";
		answer += srr[0];
		boolean check = false;
		for(int i=1;i<srr.length;i++) {
			check=srr[i-1].equals(" ") ? true : false;
			if(check)
				answer+=Character.toUpperCase(s.charAt(i));
			else
			answer+=s.charAt(i);
		}
		System.out.println(answer);
	}
}