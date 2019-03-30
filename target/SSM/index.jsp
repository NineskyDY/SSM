<html>
<body>
<h2>Hello World!</h2>
<div class="form-group">
    <label for="j_captcha" class="t">验证码：</label> <input id="j_captcha"
                                                         name="j_captcha" type="text" class="form-control x164 in" /> <img
        id="captcha_img" alt="点击更换" title="点击更换"
        onclick="changeVerifyCode(this)" src="Kaptcha" class="m" />
    <button onclick="kaihuo()">click me</button>
</div>

<a href="#" class="button button-big button-fill" id="submit">提交</a>

<script type="text/javascript"
        src="resources/js/shop/base/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
    function changeVerifyCode(img) {
        img.src = "Kaptcha?" + Math.floor(Math.random() * 100);
    }
    formData.append("verifyCodeActual", verifyCodeActual);
    $.ajax({
        url : productPostUrl,
        type : 'POST',
        data : formData,
        contentType : false,
        processData : false,
        cache : false,
        success : function(data) {
            if (data.success) {
                $.toast('提交成功！');
                $('#captcha_img').click();
            } else {
                $.toast('提交失败！');
                $('#captcha_img').click();
            }
        }
    });
    function kaihuo() {
        var a = "bb";
        $.ajax({
            url : "shop/test",
            type : "get",
            dataType : 'json',
            success : function(data) {
                alert(data);
            }
        });
    }
</script>
<script type='text/javascript'
        src='//g.alicdn.com/sj/lib/zepto/zepto.js' charset='utf-8'></script>
<script src='https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js'></script>
<script type='text/javascript'
        src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript'
        src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<script type='text/javascript'
        src='../resources/js/common/commonutil.js'
        charset='utf-8'></script>
</body>
</html>
