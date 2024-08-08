<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Custom Error Page</h1>
    <p>An error occurred: <%= exception.getMessage() %></p>
</body>
</html>
