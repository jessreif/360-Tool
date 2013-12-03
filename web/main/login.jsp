<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        login
    </head>

    <body>
        <form action="login" method="post">
            username<input type="text" name="username"><br>
            password<input type="password" name="password">
            <select name="type">
                <option value="Admin">Admin</option>
                <option value="Member">Member</option>
            </select>
            <input type="submit"/>
        </form>
    </body>
</html>

