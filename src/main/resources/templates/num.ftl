<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册成功</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<div class="col-md-12 column">
    <nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="/">登录页</a>
            </div>
        </div><!-- /.container-fluid -->
    </nav>
</div>
<br>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <br><br><br><br>
            <h3 class="text-center">
                注册成功！
            </h3>
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">你的账号为:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputEmail3"value="${number}" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <a href="/" class="btn btn-primary btn-lg active" role="button">去登录</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>