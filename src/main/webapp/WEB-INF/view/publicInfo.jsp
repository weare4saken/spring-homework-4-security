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

<security:authorize access="hasAnyRole('IT', 'STUFF', 'DIRECTOR')">
<p><input type="button" value="Серверная"
       onclick="window.location.href = 'it'">
Вход разрешен: айтишникам, охране и директору</p>
</security:authorize>
<br>

<security:authorize access="hasAnyRole('STUFF', 'DIRECTOR')">
<p><input type="button" value="Комната охраны"
       onclick="window.location.href = 'stuff'">
Вход разрешен: охране и директору</p>
</security:authorize>
<br>


<security:authorize access="hasRole('DIRECTOR')">
<p><input type="button" value="Кабинет начальства"
       onclick="window.location.href = 'director'">
Вход разрешен: только директору</p>
</security:authorize>

</body>
</html>