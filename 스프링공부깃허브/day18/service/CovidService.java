package com.itbank.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class CovidService {
	
	private final String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson";
	private final String serviceKey = "K7G5hCA%2FRqnmALDK%2F7POZXDGSgTgQFRIcOqpF8HUf9rqLn17QSaJ4Q0Ox732h%2BF%2FgxuyB3bXrdEWApNVwrOtWA%3D%3D";

	// 지정한 주소로 요청하여 XML형식의 데이터를 받아와서 반환하기
	public String getData() throws IOException {
		String requestURL = url;
		requestURL += "?pageNo=1";
		requestURL += "&numOfRows=10";
		requestURL += "&startCreateDt=20220302";
		requestURL += "&endCreateDt=20220302";
		requestURL += "&ServiceKey=" + serviceKey;
		
		return getResponse(requestURL);
	}
	
	// 내부에서만 사용할 HTTP주소를 전달받아서, 응답을 문자열로 반환하는 함수 만들기
	private String getResponse(String url) throws IOException {
		String response = "";
		int responseCode = 0;
		Scanner sc = null;
		
		URL requestURL = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();
		
		responseCode = conn.getResponseCode();
		if(responseCode == 200) {
			sc = new Scanner(conn.getInputStream());
			while(sc.hasNextLine()) {
				response += sc.nextLine();
			}
			sc.close();
			conn.disconnect();
			return response;
		}
		return null;
	}

}
