package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) throws IOException {
		File dir = new File("C:\\myfolder");
		System.out.println("지정한 요소가 존재하는가 : " + dir.exists());
		System.out.println("지정한 요소가 디렉토리인가 :" + dir.isDirectory());
		System.out.println("지정한 요소가 파일인가 : " + dir.isFile());

		File txt = new File(dir, "a.txt");
		System.out.println("지정한 요소가 존재하는가 : " + dir.exists());
		System.out.println("지정한 요소가 디렉토리인가 :" + dir.isDirectory());
		System.out.println("지정한 요소가 파일인가 : " + dir.isFile());
		System.out.println("지정한 파일이 읽기 가능한가 :" + txt.canRead());
		System.out.println("지정한 파일이 쓰기 가능한가 :" + txt.canWrite());
		System.out.println("지정한 파일이 실행 가능한가 :" + txt.canExecute());

		// 프로그램 > 파일 (데이터 내보내기)
		FileOutputStream fos = new FileOutputStream(txt);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));

//		bw.write("안녕하세요");
//		bw.write("오늘은" + new Date() + "입니다");
//		bw.write("끝\n");
		bw.append("안녕하세요");
		bw.append("오늘은" + new Date() + "입니다");
		bw.append("끝\n");
		bw.flush();
		bw.close();

		// 파일 -> 프로그램(데이터 불러오기)
		FileInputStream fis = new FileInputStream(txt);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

		String data = "";
		data += br.readLine() + "\n";
		data += br.readLine() + "\n";
		data += br.readLine() + "\n";
		br.close();
		System.out.println(data);

		// 위에 있는 파일 읽기 과정은 파일이 텍스트 형식이라면 Scanner로 보다 간편하게 처리가 가능하다
		Scanner sc = new Scanner(txt);
		String data2 = "";
		while (sc.hasNextLine()) {
			data += sc.nextLine() + "\n";
		}
		System.out.println(data2);
		sc.close();
		System.out.println(txt);
	}
}
