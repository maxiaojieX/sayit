<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link rel="shortcut icon" href="img/SSS.ico"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <img src="img/${sex}" alt="..." class="img-circle my" style="width: 50px">
                        <a class="navbar-brand" style="float: right" href="/config">设置</a>
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
<div id="config">
            <input type="text" class="form-control" id="say" placeholder="Say it">
</div>
            <#list messages as content>
            <div class="panel panel-default">
                <div class="panel-heading">

                    <div class="touxiang" style="display: inline-block">
                        <img src="img/${content.headPortraitUrl}" alt="..." class="img-circle my" style="width: 50px">
                    </div>
                    <div class="ziliao" style="display: inline-block">
                        <div class="na">${content.nickName}</div>
                        <div class="ti">${content.createTime?string("yyyy-MM-dd HH:mm:ss")}</div>
                    </div>
                    <center>
                    ${content.content}
                    </center>
                </div>
            </div>
            </#list>
            <#if messages?size=0>
                <center><h4 style="color: dimgrey">空空如也，快去发表吧...</h4></center>
            </#if>
        </div>

    </div>
<script src="js/jQuery/jquery-2.2.3.min.js"></script>
<script src="js/layer/layer.js"></script>
<script>
    $(function () {
        var id = ${id};
        $("#say").click(function () {
            location.href="/edit?id="+id
        });
    });
</script>
</body>
</html>