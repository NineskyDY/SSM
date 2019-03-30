$(function() {
    var loginUrl = '/SSM/local/loginCheck';

    //从地址栏的Url中获取user type
    //1：前端展示系统 2：店家管理系统
    var usertype = getQueryString("usertype")
    //登陆次数，累计三次失败后，弹出验证码
    var loginCount = 0;
    $('#submit').click(function() {
        var userName = $('#username').val();
        var password = $('#psw').val();
        var verifyCodeActual = $('#j_captcha').val();
        var needVerify = false;
        if(loginCount>=3){
            if (!verifyCodeActual) {
                $.toast('请输入验证码！');
                return;
            }else {
                needVerify = true;
            }
        }
        //访问后台进行登陆验证
        $.ajax({
            url : loginUrl,
            async : false,
            cache : false,
            type : "post",
            dataType : 'json',
            data : {
                userName : userName,
                password : password,
                verifyCodeActual : verifyCodeActual,
                needVerify:needVerify
            },
            success : function(data) {
                if (data.success) {
                    $.toast('登陆成功！');
                    if(usertype ==1){
                        window.location.href = '/SSM/fronted/index';
                    }else {
                        window.location.href = '/SSM/shopAdmin/shopList';
                    }

                } else {
                    $.toast('登陆失败！');
                    loginCount++;
                    if(loginCount>=3){
                        //登陆失败三次，需做验证码校验
                        $('#verifyPart').show();
                    }
                }
            }
        });
    })

})