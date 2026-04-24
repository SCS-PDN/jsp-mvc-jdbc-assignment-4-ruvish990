<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<h2>Available Courses</h2>

<c:forEach var="c"
items="${courses}">

<p>

${c.name}
-
${c.instructor}

<form method="post"
action="register/${c.id}">

<button type="submit">
Register
</button>

</form>

</p>

</c:forEach>