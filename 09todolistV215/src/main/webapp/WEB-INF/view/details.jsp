<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="academy.learnprogramming.util.Mappings"%>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Todo Items Details</title>
</head>
<body>
    <div align="center">
        <c:url var="addUrl" value="${Mappings.ITEMS}"/>
        <a href="${addUrl}">Zur&uuml;ck zur Itemsliste</a>
        <ul border="1" cellpadding="5">
            <li>Id: <c:out value="${todo_Item.id}"/></li>
            <li>Titel: <c:out value="${todo_Item.title}"/></li>
            <li>Termin: <c:out value="${todo_Item.deadline}"/></li>
            <li>Details: <c:out value="${todo_Item.details}"/></li>
        </ul>
    </div>

</body>
</html>