<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css">
        <title>todos page </title>
    </head>

    <body>
        <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1 px-4">
            <a class="navbar-brand m-1" href="https://courses.in28minutes.com">Alexotoodev</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
                </ul>
            </div>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
            </ul>
        </nav>

        <div class="container">
            <h1>Welcome ${name}</h1>
            <hr>
            <h3>Here is your list :</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger ">DELETE</a> </td>
                            <td><a href="update-todo?id=${todo.id}" class="btn btn-success ">UPDATE</a> </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success btn-lg">Add Todo</a>
        </div>

        <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.3/jquery.min.js"></script>

    </body>

    </html>