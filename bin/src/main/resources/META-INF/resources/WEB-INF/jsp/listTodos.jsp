<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>
            Welcome Todos Page
        </title>
    </head>
    <div>Welcome ${name}</div>
    <div>My First Todo page ${todos}</div>
    <table>
        <thead>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
        </thead>
        <tbody>
            <c:forEach items = "${todos}" var = "todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>