$(function() {
	var bindUrl = '/SSM/local/bindLocalAuth';

	//从地址栏的Url中获取user type
	//1：前端展示系统 2：店家管理系统
	var usertype = getQueryString("usertype")
	$('#submit').click(function() {
		var userName = $('#username').val();
		var password = $('#psw').val();
		var verifyCodeActual = $('#j_captcha').val();
		var needVerify = false;
		if (!verifyCodeActual) {
			$.toast('请输入验证码！');
			return;
		}
		$.ajax({
			url : bindUrl,
			async : false,
			cache : false,
			type : "post",
			dataType : 'json',
			data : {
				userName : userName,
				password : password,
				verifyCodeActual : verifyCodeActual
			},
			success : function(data) {
				if (data.success) {
					$.toast('绑定成功！');
					if(usertype ==1){
                        window.location.href = '/SSM/fronted/index';
					}else {
                        window.location.href = '/SSM/shopAdmin/shopList';
					}

				} else {
					$.toast('绑定失败！');
					$('#captcha_img').click();
				}
			}
		});
	});
});