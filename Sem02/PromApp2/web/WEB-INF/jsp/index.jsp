<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="appBase" value="${pageContext.request.contextPath}" />

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${appBase}/css/estilos.css" rel="stylesheet" type="text/css"/>
    <script src="${appBase}/jquery/jquery-2.2.4.min.js" type="text/javascript"></script>
    <title>PROMEDIO</title>
  </head>

  <body>
    <h1>PROMEDIO DE NOTAS</h1>
    <form id="form1">
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
        <input type="button" id="btnProcesar" value="Procesar" />
      </div>
    </form>

    
    <div  id="divRepo" style="margin: 10px;display: none;">
      <h2>REPORTE</h2>
      <p>INPUT</p>
      <table style="margin: 10px;">
        <tr>
          <td>Practica 1:</td>
          <td><span id="p1"></span></td>
        </tr>
        <tr>
          <td>Practica 2:</td>
          <td><span id="p2"></span></td>
        </tr>
        <tr>
          <td>Practica 3:</td>
          <td><span id="p3"></span></td>
        </tr>
        <tr>
          <td>Practica 4:</td>
          <td><span id="p4"></span></td>
        </tr>
        <tr>
          <td>Exa. Parcial:</td>
          <td><span id="ep"></span></td>
        </tr>
        <tr>
          <td>Exmen Final:</td>
          <td><span id="ef"></span></td>
        </tr>
      </table>
      <p>OUTPUT</p>
      <table style="margin: 10px;">
        <tr>
          <td>Práctica menor:</td>
          <td><span id="pm"></span></td>
        </tr>
        <tr>
          <td>Prom. Practicas:</td>
          <td><span id="pp"></span></td>
        </tr>
        <tr>
          <td>Promedio Final:</td>
          <td><span id="pf"></span></td>
        </tr>
        <tr>
          <td>Estado:</td>
          <td><span id="es"></span></td>
        </tr>
      </table>
    </div>

    <script>
      
      $("#btnProcesar").click(fnProcesar);
      
      function fnProcesar(){
        // Datos
        var data = $("#form1").serialize();
        // Proceso
        $.post("procesar.htm",data,function(rpta){
          var obj = $.parseJSON(rpta);
          $("#p1").text(obj.pract1);
          $("#p2").text(obj.pract2);
          $("#p3").text(obj.pract3);
          $("#p4").text(obj.pract4);
          $("#ep").text(obj.exaParcial);
          $("#ef").text(obj.exaFinal);
          $("#pm").text(obj.practMenor);
          $("#pp").text(obj.promPract);
          $("#pf").text(obj.promFinal);
          $("#es").text(obj.estado);
          $("#divRepo").show(800);
        });
        
      }
      
      $("input").keyup(function(){
        $("#divRepo").hide();
      });
      
    </script>
  </body>
</html>
