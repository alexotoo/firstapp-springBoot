<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css">
            <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
                rel="stylesheet">
            <title>add todo </title>
        </head>

        <body>
            <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
                <a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28minutes</a>
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

                <h4>Enter Todo</h4>

                <form:form method="post" modelAttribute="todo">

                    <fieldset class="mb-3">
                        <form:label path="description">Description</form:label>
                        <form:input type="text" path="description" required="required" />
                        <form:errors path="description" cssClass="text-warning" />
                    </fieldset>
                    <fieldset class="mb-3">
                        <form:label path="targetDate">Target Date</form:label>
                        <form:input type="text" path="targetDate" required="required" />
                        <form:errors path="targetDate" cssClass="text-warning" />
                    </fieldset>

                    <form:input class="form-control" type="hidden" path="id" />
                    <form:input class="form-control" type="hidden" path="done" />
                    <button type="submit" class="btn btn-primary my-2">Submit</button>
                </form:form>

            </div>

            </div>


            <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
            </script>
            <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
            <script src="webjars/jquery/3.6.3/jquery.min.js"></script>


            <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
            <script type="text/javascript">
                $('#targetDate').datepicker({
                    format: 'yyyy-mm-dd'
                });
            </script>



        </body>

        </html>