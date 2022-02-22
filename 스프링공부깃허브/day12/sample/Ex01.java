package sample;

import java.io.*;

public class Ex01 {
	// 파일 입출력 개요
	// 변수는 메모리에 데이터를 저장한다
	// 프로그램이 종료되면 메모리 내부의 데이터는 소멸한다
	// 프로그램이 종료되어도 데이터가 유지되게 하면
	// 1) 파일에 저장 - java.io 패키지 내부에서 파일 입출력 관련 클래스를 지원한다
	// 2) DB에 저장

	public static void main(String[] args) throws IOException{
		File f1 = new File("파일이름.txt"); // File 클래스의 객체는 실제파일 존재여부와 상관없이 객체를 생성할 수 있다

		File f2 = new File("디렉토리 경로", "파일 이름");
		// 파일의 경로는 현재 실행되는 프로그램의 위치를 기준으로 상대경로로 처리할 수 있다
		// 시스템 전체에서 가장 상위디렉토리를 기준으로 절대경로로 처리할 수 있다

		// 상대 경로 : 현재 위치를 기준으로 대상의 위치를 지정
		// 절대 경로 : 전체 경로, 최상위 디렉토리 혹은 윈도우의 C: , D: 와 같은 위치를 기준으로

		File f3 = new File("C:\\myfolder");
		// File 클래스는 파일과 폴더(디렉토리)개념을 포함한다
		if (f3.exists() == false) {
			f3.mkdir(); // make directory ( 새 폴더를 만들기)
		}
		File f4 = new File(f3,"a.txt");
		if(f4.exists() == false) { // 만약 파일이 존재하지 않으면
			f4.createNewFile();	// 새로운 파일을 생성한다
		}
	}
}
