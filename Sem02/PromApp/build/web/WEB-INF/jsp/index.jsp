<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="appBase" value="${pageContext.request.contextPath}" />

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${appBase}/css/estilos.css" rel="stylesheet" type="text/css"/>
    <title>PROMEDIO</title>
  </head>

  <body>
    <h1>PROMEDIO DE NOTAS</h1>
    <form method="post" action="procesar.htm">
      <div>
        <fieldset class="cssNotas">
          <legend>Practicas</legend>
          <div>
            <label>Practica 1: </label>
            <input type="text" name="pract1" />
          </div>
          <div>
            <label>Practica 2: </label>
            <input type="text" name="pract2" />
          </div>
          <div>
            <label>Practica 3: </label>
            <input type="text" name="pract3" />
          </div>
          <div>
            <label>Practica 4: </label>
            <input type="text" name="pract4" />
          </div>
        </fieldset>  
        <fieldset class="cssNotas">
          <legend>Examenes</legend>
          <div>
            <label>Examen Parcial: </label>
            <input type="text" name="exaParcial" />
          </div>
          <div>
            <label>Exmen Final: </label>
            <input type="text" name="exaFinal" />
          </div>
        </fieldset>  
      </div>
      <div style="clear: both; margin: 10px; padding: 15px;  ">
        <input type="submit" value="Procesar" />
      </div>
    </form>

    <c:if test="${repo != null}">
      <div style="margin: 10px;">
        <h2>REPORTE</h2>
        <p>INPUT</p>
        <table style="margin: 10px;">
          <tr>
            <td>Practica 1:</td>
            <td>${repo.pract1}</td>
          </tr>
          <tr>
            <td>Practica 2:</td>
            <td>${repo.pract2}</td>
          </tr>
          <tr>
            <td>Practica 3:</td>
            <td>${repo.pract3}</td>
          </tr>
          <tr>
            <td>Practica 4:</td>
            <td>${repo.pract4}</td>
          </tr>
          <tr>
            <td>Exa. Parcial:</td>
            <td>${repo.exaParcial}</td>
          </tr>
          <tr>
            <td>Exmen Final:</td>
            <td>${repo.exaFinal}</td>
          </tr>
        </table>
        <p>OUTPUT</p>
        <table style="margin: 10px;">
          <tr>
            <td>Pràctica menor:</td>
            <td>${repo.practMenor}</td>
          </tr>
          <tr>
            <td>Prom. Practicas:</td>
            <td>${repo.promPract}</td>
          </tr>
          <tr>
            <td>Promedio Final:</td>
            <td>${repo.promFinal}</td>
          </tr>
          <tr>
            <td>Estado:</td>
            <td>${repo.estado}</td>
          </tr>
        </table>
      </div>
    </c:if>
  </body>
</html>
