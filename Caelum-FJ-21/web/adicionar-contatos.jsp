<%--
  Created by IntelliJ IDEA.
  User: Thiago
  Date: 5/26/13
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Adicionar Contatos</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <link type="text/css" href="css/jquery.css" rel="stylesheet"/>
</head>
<body>
<c:import url="cabecalho.jsp"/>
        <form action="adiciona-contato" method="post">
            <table>
                <tr>
                    <td> Nome:</td>
                    <td> <input type="text" name="nome"></td>
                </tr>
                <tr>
                    <td> Email:</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>  Email:</td>
                    <td> <input type="text" name="email"></td>
                </tr>
                <tr>
                    <td> Endereço:</td>
                    <td><input type="text" name="endereco"/></td>
                </tr>
                <tr>
                    <td> Data Nascimento:</td>
                    <td><caelum:campoData id="dataNascimento"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Adicionar"/></td>
                </tr>
            </table>
        </form>
<c:import url="rodape.jsp"/>
</body>
</html>
