<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Javascript 로 처리하기</h1>
<hr>

<div class="root"></div>
<script>
	// 스프링이 보내준 데이터를 Javascript로 처리하기
	const jsonString = '${json}'
	const json = JSON.parse(jsonString) 		// 문자열을 자바스크립트 객체로 변환
	const root = document.querySelector('.root')
	
	const arr = json.response.body.items.item
	arr.sort((a, b) => a.localOccCnt - b.localOccCnt > 0 ? -1 : 1)
	
	arr.forEach(item => {
		const div = document.createElement('div')
		div.innerText = item.gubun + ' : ' + item.localOccCnt
		root.appendChild(div)
	})
	
	console.log(json)
	
</script>

<script>
	// 자바스크립트에서 직접 API 에 데이터를 요청하면...?
	let url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson'
	const serviceKey = 'K7G5hCA%2FRqnmALDK%2F7POZXDGSgTgQFRIcOqpF8HUf9rqLn17QSaJ4Q0Ox732h%2BF%2FgxuyB3bXrdEWApNVwrOtWA%3D%3D'
	url += "?pageNo=1"
	url += "&numOfRows=10"
	url += "&startCreateDt=20220302"
	url += "&endCreateDt=20220302"
	url += "&ServiceKey=" + serviceKey
	
// 	fetch(url)
// 	.then(resp => resp.json())		// 응답이 XML형식으로 넘어온다
// 	.then(json => console.log(json))// 혹은, javascript로 요청을 못하는 경우도 발생 (CORS)
	
</script>

</body>
</html>