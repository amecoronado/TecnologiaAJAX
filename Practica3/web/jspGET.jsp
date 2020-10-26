<%-- 
    Document   : JSP
    Created on : 12-oct-2020, 10:43:35
    Author     : ame_coronado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
        <!--Referencia a archivo css para dar estilo-->
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Conteste el siguiente formulario</h1>
        
        <form action="NewServlet" method="get">
            <p>Nombre:</p>
            <input type="text" name="nombre" required pattern="[A-Za-z]+" title="Letras">
            <p>Edad:</p>
            <input type="number" name="edad" required>
            <p> Sexo:<br>

            <input type="radio" name="femenino" > Femenino<br>
            <input type="radio" name="masculino" > Maculino<br>
            </p>
            <input type="submit" value="enviar">
        </form>
    </body>
</html>