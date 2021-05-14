<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GIFTS</title>
</head>
<body>

<h2>gifts</h2>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>year</th>
        <th>genre</th>
        <th>watched</th>
        <th>action</th>
    </tr>
    <c:forEach var="gift" items="${giftsList}">
        <tr>
            <td>${gift.id}</td>
            <td>${gift.title}</td>
            <td>${gift.year}</td>
            <td>${gift.genre}</td>
            <td>${gift.watched}</td>
            <td>
                <a href="/edit/${gift.id}">edit</a>
                <a href="/delete/${gift.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new gift</a>
</body>
</html>