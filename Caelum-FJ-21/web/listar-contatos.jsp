<%--
  Created by IntelliJ IDEA.
  User: Thiago
  Date: 5/26/13
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Listagem de contratos</title>
</head>
<body>
    <c:import url="cabecalho.jsp"/>
     <jsp:useBean id="contatoDao" class="br.com.caelum.jdbc.dao.ContatoDao"/>
     <table border="1">
         <tr>
             <td>Id</td>
             <td>Nome</td>
             <td>Email</td>
             <td>Endereço</td>
             <td>Data Nascimento</td>
             <td>Ação</td>
         </tr>
         <c:forEach var="contato" items="${contatoDao.lista}">
            <tr>
                <td>${contato.id}</td>
                <td>${contato.nome}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty contato.email}">
                            ${contato.email}
                        </c:when>
                        <c:otherwise>
                            Nenhum contato.
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${contato.endereco}</td>
                <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
                <td><a href="remove-contato?id=${contato.id}">Remover</a></td>
            </tr>
         </c:forEach>
     </table>
<c:import url="rodape.jsp"/>
</body>
</html>