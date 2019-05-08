<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1 align="center">Beer Recommendations JSP</h1>
<p>
    <x:forEach var="beer" items="${styles}">
            <br> try: ${beer}
    </x:forEach>
</body>
</html>
