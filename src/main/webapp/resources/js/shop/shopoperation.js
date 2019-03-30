/*
 * @description: js
 * @author: 九霄环佩
 * @date: 2019/1/28
 */
$(function ()    {
    var shopId = getQueryString('shopId');
    var isEdit = shopId ? true : false;
    //获取各种初始分类信息
    var initUrl = '/SSM/shopAdmin/getshopinitinfo';
    //注册店铺
    var registershopUrl = '/SSM/shopAdmin/registerShop';
    var shopInfoUrl = "/SSM/shopAdmin/getShopById?shopId="+shopId;
    var editShopUrl = '/SSM/shopAdmin/modifyShop';
    if (isEdit) {
        registershopUrl = editShopUrl;
        getInfo(shopId);
    }
    else {
        getShopInitInfo();
    }
    function getInfo(shopId) {
        $.getJSON(shopInfoUrl, function(data) {
            if (data.success) {
                var shop = data.shop;
                $('#shop-name').val(shop.shopName);
                $('#shop-addr').val(shop.shopAddr);
                $('#shop-phone').val(shop.phone);
                $('#shop-desc').val(shop.shopDesc);
                var shopCategory = '<option data-id="'
                    + shop.shopCategory.shopCategoryId + '" selected>'
                    + shop.shopCategory.shopCategoryName + '</option>';
                var tempAreaHtml = '';
                data.areaList.map(function(item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                });
                $('#shop-category').html(shopCategory);
                $('#shop-category').attr('disabled','disabled');
                $('#area').html(tempAreaHtml);
                $("#area option[data-id='"+shop.area.areaId+"']").attr("selected","selected");
            }
        });
    }
    function getShopInitInfo() {
        //第一个参数为需要访问的url,第二个参数为回调的方法
        $.getJSON(initUrl, function (data) {
            if (data.success) {
                var tempHtml = '';
                var tempAreaHtml = '';
                data.shopCategoryList.map(function (item, index) {
                    tempHtml += '<option data-id="' + item.shopCategoryId
                        + '">' + item.shopCategoryName + '</option>';
                });
                data.areaList.map(function (item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId
                        + '">' + item.areaName + '</option>';
                });
                $('#shop-category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        })
    }

        $('#submit').click(function() {
            var shop={};
            if(isEdit) shop.shopId = shopId;
            shop.shopName = $('#shop-name').val();
            shop.shopAddr = $('#shop-addr').val();
            shop.phone = $('#shop-phone').val();
            shop.shopDesc = $('#shop-desc').val();
            shop.shopCategory = {
                shopCategoryId : $('#shop-category').find('option').not(function() {
                    return !this.selected;
                }).data('id')
            };
            shop.area = {
                areaId : $('#area').find('option').not(function() {
                    return !this.selected;
                }).data('id')
            };
            var shopImg = $("#shop-img")[0].files[0];
            var formData = new FormData();
            formData.append("shopImg",shopImg);
            formData.append("shopStr",JSON.stringify(shop));
            $.ajax({
                url : registershopUrl,
                type : 'POST',
                data : formData ,
                contentType: false,
                processData : false,
                cache:false,
                success:function(data){
                    if(data.success){
                        alert('提交成功')
                    }else {
                        alert('提交失败'+data.errMsg);
                    }
                }

            })
         });

})