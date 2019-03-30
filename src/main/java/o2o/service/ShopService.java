package o2o.service;

import o2o.dto.ShopExecution;
import o2o.entity.Shop;
import o2o.exceptions.ShopOperationException;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface ShopService {

 /*
  * @description: 根据shopCondition分页返回相应的店铺列表
  * @date: 2019/2/19
  * @param：[shopCondition, rowIndex, pageSize]
  * @return: o2o.dto.ShopExecution
  */
  ShopExecution getShopList(Shop shopCondition, int pageIndex,int pageSize);
   /*
    * @description:  注册店铺信息包括图片处理
    * @date: 2019/2/16
    * @param：[shop, shopImg]
    * @return: o2o.dto.ShopExecution
    */
    ShopExecution addShop(Shop shop,  CommonsMultipartFile shopImg) throws RuntimeException;

    /*
     * @description: 根据shopId返回shop
     * @date: 2019/2/16
     * @param：[shopId]
     * @return: o2o.entity.Shop
     */
    Shop getByShopId(long shopId);
    /*
     * @description:更新店铺信息包括图片处理
     * @date: 2019/2/16
     * @param：[shop, shopImgInputStream, fileName]
     * @return: o2o.dto.ShopExecution
     */
    ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg,String fileName)throws ShopOperationException;


}
