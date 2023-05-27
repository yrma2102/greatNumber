<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Great Number</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1> Welcome to the great Number Game!</h1>
<p>I am thinking of a number between 1 and 100</p>
<p>Take a guess!</p>

<div class="">  <c:out value="${luckyNumber}"/>  numero de la suerte</div>
<h3><c:out value="${message}"/></h3>
<c:if test="${reset}">
     <a href="/greatNumber/GameOver">Play again!</a>
</c:if>

 <form action="/greatNumber/Game" method="post">
      <label for="userNumber"></label>
    <input type="userNumber" id="userNumber" name="userNumber"><br><br>
  <br>
  <input class="button" type="submit" value="Submit">
 </form>
 <a href="/greatNumber/GameOver">Game Over</a>
</body>
</html>