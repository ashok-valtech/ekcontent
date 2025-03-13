<%@include file ="common/header.jsp" %>
<%@include file ="common/navigation.jsp" %>
        
   <div class="container">
    <h1>Your Todos are</h1>
    <table class = "table">
        <thead><tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th> DELETE </th>
            <th> UPDATE </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items = "${todos}" var = "todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href = "delete-todo?id=${todo.id}" class = "btn btn-warning">DELETE</a></td>
                    <td><a href = "update-todo?id=${todo.id}" class = "btn btn-success">UPDATE</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
   <%@include file ="common/footer.jsp" %>