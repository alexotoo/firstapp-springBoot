<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css">

    <title>Welcome </title>
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
    <div class="px-4">
        <h1 class="py-4">Your Welcome Page</h1>
        <h3>hello - ${name}
            <p><a href="list-todos">Manage your todos</a></p>
        </h3>
    </div>



    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.3/jquery.min.js"></script>
</body>

</html>