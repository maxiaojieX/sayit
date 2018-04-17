<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>好友</title>
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
                        <img src="img/${sex}" alt="..." class="img-circle my" style="width: 50px">
                        <a class="navbar-brand" style="float: right" id="config">添加好友</a>
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
        <#list friends as friend>
            <li class="list-group-item fangwen" bid="${friend.bid}"><a href="#">${friend.nickName}</a><span style="margin-left: 10px">(什么签名啊啊)</span>
            <#--<span style="float: right"><a class="btn btn-default" href="#" role="button" style="position: relative;top: -7px">给TA留言</a></span>-->
                <span style="float: right"><i class="icon-angle-right" aria-hidden="true"></i></span>
            </li>
        </#list>
        </ul>
    </div>
</div>


<script src="js/jQuery/jquery-2.2.3.min.js"></script>
<script src="js/layer_mobile/layer.js"></script>
<script>
    $(function () {

        $(".fangwen").click(function () {
            var bid = $(this).attr("bid");
            location.href="/friendsHome?bid="+bid

        });
        $("#config").click(function () {
            layer.open({
                content: '<input type="text" class="form-control" id="findFriends" placeholder="输入要查找的用户">'
                , btn: ['搜索']
                , yes: function (index) {
//                  查找好友
                    var user = $("#findFriends").val();
                    $.get("/findFriends?name="+user).done(function (json) {
                        var jsons =json.split("_");
                        var id = jsons[0];
                        var sex = jsons[1];
                        var name = jsons[2];
                        if(json == "NONE"){
                            layer.open({
                                content: '此用户不存在'
                                ,skin: 'msg'
                                ,time: 2 //2秒后自动关闭
                            });
                        }else{
                            layer.open({
                                content: '<img src="img/'+sex+'" alt="..." class="img-circle my" style="width: 50px">  '+name+''
                                ,btn: ['加为好友', '取消']
                                ,yes: function(index){
//                                    加好友 json.id
                                    $.get("/makeFriend?bid="+id).done(function (json) {
                                        if(json=="SUCCESS") {
                                            layer.open({
                                                content: '添加成功'
                                                ,skin: 'msg'
                                                ,time: 2 //2秒后自动关闭
                                            });
                                            history.go(0);
                                        }
                                    });
                                    layer.close(index);
                                }
                            });

                        }
                    });
                    layer.close(index);
                }
            });
        });

    });
</script>
<script>
</script>
</body>
</html>