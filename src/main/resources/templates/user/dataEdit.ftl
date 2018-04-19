<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link rel="shortcut icon" href="img/SSS.ico"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.css">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <a class="navbar-brand" href="/home">返回</a>
                    <#--<a class="navbar-brand" style="float: right" href="#">编辑</a>-->
                    </div>
                </div><!-- /.container-fluid -->
            </nav>
        </div>
        <nav class="navbar navbar-default navbar-inverse navbar-fixed-bottom" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                <#--<a class="navbar-brand" href="#">最近</a>-->
                <#--<div class="test" style="position: relative;left: 27%;display: inline-block"">-->
                <#--<a class="navbar-brand" href="/friends" id="friends">好友</a>-->
                <#--</div>-->
                    <a class="navbar-brand" href="/friends" id="friends">好友</a>
                    <a class="navbar-brand" style="float: right" href="/home" >Home</a>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
    </div>

    <div class="row clearfix" style="margin-top: 50px;margin-bottom: 50px; >

        <div class="col-md-12 column">
    <ul class="list-group">
        <li class="list-group-item">
            <div>
                <img src="img/${sex}" alt="..." class="img-circle my" style="width: 50px">
                <h3 style="display: inline-block;font-weight: bold"> &nbsp;${adminConfig.nickName}</h3>
            </div>
            <br>
            签名:<span>${adminConfig.autograph}</span>
        </li>

        <li class="list-group-item modify" rel="${adminConfig.nickName}">修改昵称<span style="float: right"><i class="icon-angle-right" aria-hidden="true"></i></span></li>
        <li class="list-group-item modify" rel="${adminConfig.autograph}">修改签名 <span style="float: right"><i class="icon-angle-right" aria-hidden="true"></i></span></li>
        <li class="list-group-item modify" rel="${adminConfig.welcoming}">设置欢迎语<span style="float: right"><i class="icon-angle-right" aria-hidden="true"></i></span></li>
        <li class="list-group-item modifySex" rel="${adminConfig.sex}">修改性别<span style="float: right"><i class="icon-angle-right" aria-hidden="true"></i></span></li>
        <li class="list-group-item" >修改头像 (暂未开放)<span style="float: right"><i class="icon-angle-right" aria-hidden="true"></i></span></li>
        <li class="list-group-item modify">修改密码<span style="float: right"><i class="icon-angle-right" aria-hidden="true"></i></span></li>

    </ul>
</div>

</div>

</div>
<script src="js/jQuery/jquery-2.2.3.min.js"></script>
<script src="js/layer/layer.js"></script>
<script>
    $(function () {

    });
</script>
</body>
</html>