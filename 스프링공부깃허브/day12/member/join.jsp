<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<textarea class="agreement" readonly>${agreement }</textarea>
<form>
	<div class="sb">
		<label> <input type="checkbox" name="agreement" required>
			약관에 동의합니다
		</label> <input type="submit" value="다음">
	</div>

</form>
</body>
</html>