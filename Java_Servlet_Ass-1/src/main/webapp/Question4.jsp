<!DOCTYPE html>
<html>
<head>
    <title>Session Management</title>
</head>
<body>
    <h1>Session Management</h1>
    <form action="manageSession" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username">
        <input type="submit" value="Set Session">
    </form>
    <form action="manageSession" method="get">
        <input type="submit" value="Get Session">
    </form>
</body>
</html>
