<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTAR CLIENTES</title>
  </head>
  <body>
    <h1>CONSULTAR CLIENTES</h1>
    <form id="form1">
      
      <div>
        <label>Paterno, Materno o Nombre</label><br/>
        <input type="text" name="dato" size="40"/>
        <input id="btnProcesar" type="button" value="Consultar" />
      </div>
      
      <div id="divRpta" style="display: none;">
        <table border="1">
          <thead>
            <tr>
              <th>CODIGO</th>
              <th>PATERNO</th>
              <th>MATERNO</th>
              <th>NOMBRE</th>
            </tr>
          </thead>
          <tbody id="datos"></tbody>
        </table>
      </div>
      
    </form>
    <script>
      
      $("#btnProcesar").click(fnProcesar);
      
      function fnProcesar(){
        $("#divRpta").hide();
        var data = $("#form1").serialize();
        $.post("conClientes.htm",data,function(respuesta){
          var lista = $.parseJSON(respuesta);
          var tabla = $("#datos");
          tabla.empty();
          $(lista).each(function(index,cliente){
            var row = "<tr><td>" + cliente.codigo + "</td>";
            row += "<td>" + cliente.paterno + "</td>";
            row += "<td>" + cliente.materno + "</td>";
            row += "<td>" + cliente.nombre + "</td></tr>";
            tabla.append(row);
          });
          $("#divRpta").show("slow");
        });
      }
      
      
    </script>
  </body>
</html>
