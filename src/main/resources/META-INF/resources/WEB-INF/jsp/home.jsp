<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring Boot JSP</title>
</head>
<body>
    <h2>${message}</h2>
    
    <!-- JSTL Example -->
     
    <ul>
        <c:forEach var="item" items="${['Java', 'Spring Boot', 'JSP', 'JSTL']}">
            <li>${item}</li>
        </c:forEach>
    </ul>
</body>
</html>
