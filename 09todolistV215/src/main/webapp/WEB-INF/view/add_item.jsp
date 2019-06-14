<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page import="academy.learnprogramming.util.AttributeNames"%>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Add Items</title>
</head>
<body>
    <div align="center">
        <f:form method="POST" modelAttribute="${AttributeNames.TODO_ITEM}">
            <table>
                <tr>
                    <td><label>ID</label></td>
                    <td><f:input path="id" disabled="true"/></td>
                </tr>
                <tr>
                    <td><label>Titel</label></td>
                    <td><f:input path="title"/></td>
                </tr>
                <tr>
                    <td><label>Termin</label></td>
                    <td><f:input path="deadline"/></td>
                </tr>
                <tr>
                    <td><label>Details</label></td>
                    <td><f:textarea path="details"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </f:form>
    </div>

</body>
</html>