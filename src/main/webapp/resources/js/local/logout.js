$(function() {
    $('#log-out').click(function () {
    //    清楚session
        $.ajax({
            url : "/SSM/local/logout",
            type : "post",
            async:false,
            cache:false,
            dataType : "json",
            success : function(data) {
                if (data.success) {
                    var usertype = $("#log-out").attr("usertype");
                    //清除后退回登陆界面
                    window.location.href = "/SSM/local/login?usertype="+usertype;
                    alert("到这了");
                    return false;
                }
            },
            error:function (data,error) {
                alert(error);
            }
        });
    })
})