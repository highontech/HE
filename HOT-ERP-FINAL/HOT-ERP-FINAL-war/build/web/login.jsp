<%-- 
    Document   : login
    Created on : Jul 30, 2018, 1:57:33 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>LOGIN-HOT ERP</title>

    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="metisMenu/metisMenu.min.css" rel="stylesheet"> 
    <link href="css/sb-admin-2.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>


<body>
<div class="login-wrapper">
        <nav class="navbar navbar-default navbar-static-top logo-blue" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.html" >High On Tech ERP.V-1.0</a>
            </div>
        </nav>
    <br>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                         <form role="form" action="loginservlet" method="POST">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                   <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                 <div class="form-group" type="text" >
                                            
                                            <div class="form-group">                                                 
                                               <select id="disabledSelect" class="form-control" name="designation" >
                                                <option value="" disabled selected hidden> Choose Designation</option>
                                                <option value="CEO">CEO</option>
                                                <option value="CTO">CTO</option>
                                                <option value="Intern">Intern</option>
                                                <option value="Employee">Employee</option>
                                                <option value="MO">MO</option>
                                                <option value="Manager">Manager</option>      
                                               </select>   
                                          </div>
          
                                <!-- Change this to a button or input when using this as a form -->
                               <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
