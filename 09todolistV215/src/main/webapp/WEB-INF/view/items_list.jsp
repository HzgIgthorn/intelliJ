<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="academy.learnprogramming.util.Mappings"%>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Todo Items</title>
</head>
<body>
    <div align="center">
    <c:url var="addUrl" value="${Mappings.ADD_ITEM}"/>
    <a href="${addUrl}">Neues Item</a>

        <table border="1" cellpadding="5">
             <caption><h2>Todo Items</h2></caption>
             <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>Edit</th>
                <th>Delete</th>
                <th>Details</th>
             </tr>
             <c:forEach var="item" items="${todoData.items}">
                <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <c:url var="editUrl" value="${Mappings.ADD_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <c:url var="detailUrl" value="${Mappings.DETAILS}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>
                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${editUrl}">Edit</a></td>
                    <td><a href="${deleteUrl}">Delete</a></td>
                    <td><a href="${detailUrl}">Details</a></td>
                </tr>
             </c:forEach>
        </table>
    </div>

</body>
</html>