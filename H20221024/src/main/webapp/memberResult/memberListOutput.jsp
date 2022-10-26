<%@page import="java.util.List"%>
<%@page import="co.edu.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록(memberListOutput.jsp)</title>
</head>
<body>
	<%
	List<MemberVO> result = (List<MemberVO>) request.getAttribute("memberList");
	%>

	<h3>회원정보리스트 보기</h3>
	<%
	if (result.size() > 0) {
	%>
	<table border='1'>
		<tr>
			<th>회원아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<%
		for (MemberVO vo : result) {
		%>
		<tr>
			<td><a href="./memberSearchForm.do?id=<%=vo.getId()%>&job=search"><%=vo.getId()%></a></td>
			<td><%=vo.getPasswd()%></td>
			<td><a href="./memberModifyForm.do?id=<%=vo.getName()%>&job=search"><%=vo.getName()%></td>
			<td><%=vo.getEmail()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<p>회원정보가 없습니다!!!</p>
	<%
	}
	%>

<input type= "button" value="메인화면" onClick="location.href='http://localhost:8081/H20221024/'">
</body>
</html>