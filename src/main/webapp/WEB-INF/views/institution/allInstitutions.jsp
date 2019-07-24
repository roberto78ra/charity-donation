<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <title>All Institutions page</title>
</head>
<body>
<h2 align="center">All charity institutions displayed below: </h2>
<div align="center">
    <table cellpadding="5" border="5px">
        <tr>
            <th>Full name</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${allInstitutions}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.description}</td>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="<c:url value="/index"/>"><button>Back to Index page</button></a></td>
        </tr>

    </table>
</div>
</body>