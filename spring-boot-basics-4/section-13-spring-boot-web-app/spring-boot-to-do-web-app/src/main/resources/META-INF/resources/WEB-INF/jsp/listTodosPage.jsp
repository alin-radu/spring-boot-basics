<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<body>
<div class="container">
    <h1>Your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>No</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo" varStatus="status">
            <tr>
                <td>${status.count}.</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="add-todo" class="btn btn-success">Add Todo</a>

    <%@ include file="common/footer.jspf" %>
