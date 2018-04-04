<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018-01-16
  Time: 下午 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="../patial/header.jsp"/>

    <style type="text/css">
        .razor-masthead {
            background-color: #6f5499;
            -webkit-box-shadow: inset 0 -2px 5px rgba(0, 0, 0, .1);
            box-shadow: inset 0 -2px 5px rgba(0, 0, 0, .1);
            border-radius: 20px;
            width: 550px;
            height: 450px;
            margin-top:5%;
            padding-top:15px;
        }

        body{
            background-color:#00b3ee;
        }
    </style>

    <script type="text/javascript">
        $(document).ready(function(){
            var txtUserName = $("#userName");
            var txtPassword = $("#userPassword");
            var txtVerifyCode = $("#patial_txt_kaptcha");

            $("#btnLogin").on("click",function(){
                if(txtUserName.val() == "" || txtPassword.val() == "" || txtVerifyCode.val() == ""){
                    return false;
                }

                var model = {
                    name:txtUserName.val(),
                    password:txtPassword.val(),
                    verifyCode:txtVerifyCode.val()
                };

                $.ajax({
                    url:"../account/doLogin",
                    type:"post",
                    dataType:"json",
                    contentType:"application/json;charset=UTF-8",
                    data:JSON.stringify(model),
                    success:function(data){
                        alert(data);
                    },
                    error:function(er){
                        alert(JSON.stringify(er));
                    }
                });
            });
        });
    </script>
</head>
<body>

<div class="container razor-masthead">
    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <label for="userName">UserName:</label>
                <input type="text" pattern="^[A-z0-9]{6,32}$" class="form-control" name="userName" id="userName" placeholder="UserName" data-error="User name can not be empty!" required/>
                <div class="help-block with-errors"/>
            </div>

            <div class="form-group">
                <label for="userpassword">Password:</label>
                <input type="password" class="form-control" name="userPassword" id="userPassword" placeholder="Password" data-error="Password can not be empty" required/>
                <div class="help-block with-errors"/>
            </div>

            <div class="form-group">
                <label>VerifyCode:</label>
                <jsp:include page="../patial/kaptcha.jsp"/>
            </div>

            <div class="form-group">
                <input type="button" class="btn btn-success" value="Login" id="btnLogin"/>
                <input type="button" class="btn btn-danger" value="Cancel" id="btnCancel"/>
            </div>
        </div>
    </div>

</div>

</body>
</html>
