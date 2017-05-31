<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>SUMAR</h1>
        <fieldset style="width: 300px;">
            <legend>Datos</legend>
            <form method="post" action="procesar.egcc">
                <div>
                    <label>Número 1:</label>
                    <input type="text" name="num1">
                </div>
                <div>
                    <label>Número 2:</label>
                    <input type="text" name="num2">
                </div>
                <div>
                    <input type="submit" value="Procesar">
                </div>
            </form>
        </fieldset>
        
        <c:if test="${suma != null}" >
            <h2>RESULTADO</h2>
            <p>Número 1: ${n1}</p>
            <p>Número 2: ${n2}</p>
            <p>Suma: ${suma}</p>
        </c:if>
    </body>
</html>
