<%-- 
    Document   : AboutMe
    Created on : Feb 6, 2021, 5:35:13 PM
    Author     : Tyrese Fisher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Me</title>
    </head>
    <body>
        <h1 style = "color:blue;">About Me!</h1>
    <!-- creating form which forwards to the decision maker controller-->
        <form action = "decisionmaker" method = "POST">
        <p>Tell us more about yourself</p>
    <!-- IQ: Drop down list, 4 options, single select -->
        <p><label style = "color:blue;">IQ:</label></p>
            <select name="iq">
        <!-- the value goes between the last > -->
            <option selected value = "Less Than 120">Less Than 120</option>
            <option value = "121 To 150">121 to 150</option>
            <option value = "151 To 180">151 to 180</option>
            <option value = "Greater Than 180">Greater than 180</option>
            </select>           
    <!-- favorite beverage: radio button single select-->
        <p><label style = "color:blue;">Favorite Beverage:</label></p>
        <input checked type="radio" name="beverage" value="Water" /> Water
        <input type="radio" name="beverage" value="Juice" /> Juice
        <input type="radio" name="beverage" value="Cola" /> Cola
        <input type="radio" name="beverage" value="Beer" /> Beer
        <input type="radio" name="beverage" value="Wine" /> Wine
    <!--Superpower checkbox: multi select-->
        <p><label style = "color:blue;">Super Power:</label></p>
        <input type="checkbox" name="superpower" value="Super Strength" /> Super Strength <br>
        <input type="checkbox" name="superpower" value="Flight" /> Flight <br>
        <input type="checkbox" name="superpower" value="Time Travel" /> Time Travel <br>
        <input type="checkbox" name="superpower" value="Mind Control" /> Mind Control <br>
        <input type="checkbox" name="superpower" value="Coding" /> Coding <br><br>
            <input type="hidden" name="fullname" value="${fullname}">
            <input type="hidden" name="email" value="${email}">
    <!--Join Me button -->
    <input type="submit" value="Join Now" /><br><br>
    <!--go back link -->
        <a href="index.html"> Go Back</a>
    </form>
    </body>
</html>
