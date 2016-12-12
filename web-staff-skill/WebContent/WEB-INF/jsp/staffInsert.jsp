<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title></title>
</head>
<body>
<div class="container">

		<form action="<c:url value='/jsp/insertFormAction.staff'/>" method="post">
			<table class="table table-bordered">
				<tr>
					<th>�̸�</th>
					<td><input type="text" name="staffName" /></td>
					<th>�ֹι�ȣ</th>
					<td>
					<input type="text" name="staffNum1" maxlength="6" />-<input type="password" maxlength="7" name="staffNum2"></td>
					<th>����</th>
					<td>
						<select name="religionName">	
							<c:forEach var="r" items="${religion}">
								<option value="${r.no}">${r.name}</option>
							</c:forEach>
					</select>
						</td>
				</tr>
				<tr>
					<th>�з�</th>
					<td>
						<c:forEach var="school" items="${school}">
					${school.graduate}<input type="radio" name="graduate" value="${school.no}">
						</c:forEach>
					</td>
					<th>���</th>
					<td colspan="3">
						<c:forEach var="skill" items="${skill}">
							${skill.name}<input type="checkbox" class="skill" name="skill" value="${skill.no}">
						</c:forEach>
					</td>
				</tr>
				<tr>
				<th>������</th>
					<td colspan="5"><input type="date" name="date"></td>
				</tr>
				<tr>
					
    					<td colspan="6" style = "text-align:center;"><input type="submit" value="�Է�" />|<input type="reset" value="�ʱ�ȭ"></td>
					
				</tr>
				
			</table>
		</form>
				

	</div>
</body>
</html>