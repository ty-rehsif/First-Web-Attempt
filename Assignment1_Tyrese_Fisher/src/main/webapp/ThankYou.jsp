<%-- 
    Document   : ThankYou
    Created on : Feb 6, 2021, 5:35:29 PM
    Author     : Tyrese Fisher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel ="stylesheet" href="customcsssheet.css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank You!</title>
        
    </head>
    <body>
        <h1>Thank You!</h1><br>
        <section>
    <!-- EL Language displaying attributes -->
        <p style="font-size: 150%; color:navy; font-weight: bold; text-decoration: underline;">Applicant Info:</p>
        <p>Name: ${fullname}</p>
        <p>Email: ${email}</p>
        <p>IQ: ${iq}</p>
        <p>Favorite Beverage: ${beverage}</p>
        <p>Super Power: ${superpower}</p>
        <p style="color:navy; font-weight: bold; font-size: 125%;">Your Score is: ${score} </p>
        <p style="color:red; font-weight: bold; font-size: 125%;">${message}</p>
        </section>
        <br><a href="index.html"> Next Applicant</a>
    </body>
</html>
