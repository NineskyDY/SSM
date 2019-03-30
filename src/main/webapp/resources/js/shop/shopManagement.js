$(function () {
   var shopId = getQueryString("shopId");
   var shopInfoUrl = 'getShopManagementInfo?shopId='+shopId;
   // alert(shopInfoUrl);
   $.getJSON(shopInfoUrl,function (data) {
       if (data.redirect){
           window.location.href = data.url;
       }else {
           if (data.shopId!=undefined&&data.shopId!=null){
               shopId=data.shopId;
           }
           $('#shopInfo').attr('href','/SSM/shopAdmin/shopEdit?shopId='+shopId);
       }
   })
});