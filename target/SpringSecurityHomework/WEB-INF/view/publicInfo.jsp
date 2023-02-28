<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kolod
  Date: 28.02.2023
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>ДОБРО ПОЖАЛОВАТЬ В ОБЩЕЕ ПОМЕЩЕНИЕ</h1>
<br>
<br>

<security:authorize access="hasAnyRole('IT', 'STUFF', 'DIRECTOR')">
<p><input type="button" value="Серверная"
       onclick="window.location.href = 'itInfo'">
Вход разрешен: айтишникам, охране и директору</p>
</security:authorize>
<br>
<br>

<security:authorize access="hasAnyRole('STUFF', 'DIRECTOR')">
<p><input type="button" value="Комната охраны"
       onclick="window.location.href = 'stuffInfo'">
Вход разрешен: охране и директору</p>
</security:authorize>
<br>
<br>

<security:authorize access="hasRole('DIRECTOR')">
<p><input type="button" value="Кабинет начальства"
       onclick="window.location.href = 'directorInfo'">
Вход разрешен: только директору</p>
</security:authorize>

</body>
</html>