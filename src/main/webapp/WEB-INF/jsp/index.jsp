<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

    <title>Library | Home</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="static/js/html5shiv.min.js"></script>
    <script src="static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">Home</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="new-book">New Book</a></li>
                <li><a href="all-books">All Books</a></li>
                <li><a href="book-search-page">Book Search</a></li>
            </ul>
        </div>
    </div>
</div>

<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Welcome to library page</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_BOOKS'}">
        <div class="container text-center" id="tasksDiv">
            <h3>Add new book</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Book Name</th>
                        <th>Author</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>${book.id}</td>
                            <td>${book.book_name}</td>
                            <td>${book.author}</td>
                            <td><a href="update-book?id=${book.id}"><span class="glyphicon glyphicon-pencil"></span></a>
                            </td>
                            <td><a href="delete-book?id=${book.id}"><span class="glyphicon glyphicon-trash"></span></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
        <div class="container text-center">
            <h3>Manage Books</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="save-book">
                <input type="hidden" name="id" value="${book.id}"/>
                <div class="form-group">
                    <label class="control-label col-md-3">Book name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="book_name" value="${book.book_name}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Author</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="author" value="${book.author}"/>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </form>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_OK'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Operation is successfull</h1>
            </div>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_ERROR'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Oops! Something went wrong</h1>
            </div>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_SEARCH'}">
        <div class="container text-center">
            <h3>Search Books</h3>
            <form class="form-horizontal" method="GET" action="search">
                <div class="form-group">
                    <label class="control-label col-md-3">Book name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="book_name" value="${book.book_name}"/>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Search"/>
                </div>
            </form>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_FOUND'}">
        <div class="container text-center" id="tasksDiv">
            <h3>Here`s books that we found</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Book Name</th>
                        <th>Author</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="book" items="${booksFound}">
                        <tr>
                            <td>${book.id}</td>
                            <td>${book.book_name}</td>
                            <td>${book.author}</td>
                            <td><a href="update-book?id=${book.id}"><span class="glyphicon glyphicon-pencil"></span></a>
                            </td>
                            <td><a href="delete-book?id=${book.id}"><span class="glyphicon glyphicon-trash"></span></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_NOTHING_FOUND'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Sorry. There are no books with that name</h1>
            </div>
        </div>
    </c:when>
</c:choose>

<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>