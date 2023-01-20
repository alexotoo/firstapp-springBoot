<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css">
        <title>add todo </title>
    </head>

    <body>
        <div class="container">

            <h1>Welcome ${name}</h1>
            <hr>

            <h4>Enter Todo</h4>

            <form method="post">
                <input class="form-control" type="text" placeholder="enter description">
                <button type="submit" class="btn btn-primary my-4">Submit</button>
            </form>

        </div>

        </div>

        <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.3/jquery.min.js"></script>

    </body>

    </html>