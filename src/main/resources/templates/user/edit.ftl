<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的</title>
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
                        <a class="navbar-brand" style="float: right" href="#" id="config">给TA留言</a>
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
    </div>
    </nav>
</div>

<div class="row clearfix" style="margin-top: 50px;margin-bottom: 50px>
    <div class="col-md-12 column">


<form action="/save" method="post" id="saveForm">
    <input type="hidden"value="${aid}" name="aid">
    <textarea class="form-control" name="content" rows="3" style="height: 240px"></textarea>
    <div class="checkbox" style="margin-left: 14px;display: inline-block">
        <label>
            <input type="checkbox" name="simi"> 私密模式
        </label>
    </div>
    <div class="checkbox" style="margin-left: 14px;display: inline-block">
        <label>
            <input type="checkbox" name="reply"> 禁止回复
        </label>
    </div>
    <button type="button" class="btn btn-primary" style="float: right;margin-right: 14px;margin-top: 6px" id="saveBtn">发表</button>
</form>
</div>
</div>

<script src="js/jQuery/jquery-2.2.3.min.js"></script>
<script src="js/layer/layer.js"></script>
<script>
    $(function () {
        var aid = ${aid};
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });
    });
</script>
<script>
</script>
</body>
</html>