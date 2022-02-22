package sample;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

public class Ex03 {
	static String getHash(String data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.reset();
		md.update(data.getBytes("UTF-8"));
		String hash = String.format("%0128x",new BigInteger(1,md.digest()));
		return hash;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc =new Scanner(System.in);
		String password = "1234";
		String hash1 = getHash(password);
		
		String userpw;
		System.out.println("비밀번호 입력");
		userpw=sc.next();
		String hash2 = getHash(userpw);
		System.out.println(password.equals(userpw));
		System.out.println(hash1.equals(hash2));
		// 자바에서 문자열을 해시처리하는 코드
		
		// 1) 원본 문자열을 다른 형식으로 변경하는 내용
		// 2) Hash는 단방향 함수이므로, 변경된 데이터를 다시 원래의 형식으로 되돌리기 힘들다
		// (Encryption, 암호화는 대응되는 복호화 방식이 있어서 되돌릴 수 있다)
		// 3) Hash에 의해서 데이터가 변경되어도, 일치여부는 정확하게 확인이 가능하다
		// 4) y = f(x) 에 같은 x 값을 넣으면, 값은 y값이 나온다
		// 5) Hash는 서로 다른 입력값이 같은 결과를 가지는 경우를 배제한다
	}
}
