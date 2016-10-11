<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 10-Oct-16
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>

<form method="POST" action="AddCity">
    <p><input type="text" name="cityName" value="" placeholder="city name"></p>
    <input type="submit"  value="Add City">
</form>

<form method="POST" action="AddDistance">
    <p><input type="text" name="cityName1" value="" placeholder="city 1 name"></p>
    <p><input type="text" name="cityName2" value="" placeholder="city 2 name"></p>
    <p><input type="text" name="distance" value="" placeholder="Distance between cities"></p>
    <input type="submit"  value="Add City Map">
</form>

</body>
</html>

