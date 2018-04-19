<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>
    <link rel="shortcut icon" href="img/SSS.ico"/>
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/component.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!--[if IE]>
    <script src="js/html5.js"></script>

    <![endif]-->
</head>
<body>
<div class="container demo-1">
    <div class="col-md-12 column">
        <nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">返回</a>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
    </div>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h3 class="text-center">
                    注册
                </h3>
                <form class="form-horizontal" id="regForm" action="/doReg" role="form" method="post">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="inputEmail3" placeholder="请输入你的邮箱"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入昵称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="请输入密码" />
                        </div>
                    </div>
                    <button type="button" class="btn btn-default" id="getCode">获取验证码</button>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="code" name="code" placeholder="请输入验证码" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" id="relReg" style="float: right" class="btn btn-default">注册</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="js/jQuery/jquery-2.2.3.min.js"></script>
<script src="js/layer/layer.js"></script>
<script>
    $(function () {

        $("#getCode").click(function () {
            var em = $("#inputEmail3").val();
            $.get("/getCode?email="+em).done(function (json) {
                layer.msg(json);
            });
        });

        $("#relReg").click(function () {

            var em = $("#inputEmail3").val();
            var pa = $("#inputPassword3").val();
            var name = $("#nickName").val();
            var co = $("#code").val();

            if(em != null && pa != null && name != null && co != null && em != "" && pa != "" && name != "" && co != "") {
                $("#regForm").submit();
            }else {
                layer.msg("不允许留空");
            }

        });

    });
</script>
</body>
</html>