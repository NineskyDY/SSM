package o2o.service.impl;

import o2o.dao.ShopDao;
import o2o.dto.ShopExecution;
import o2o.entity.Shop;
import o2o.enums.ShopStateEnum;
import o2o.exceptions.ShopOperationException;
import o2o.service.ShopService;
import o2o.util.ImageUtil;
import o2o.util.PageCalculator;
import o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service 
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex,pageSize);
        List<Shop> shopList = shopDao.queryShopList(shopCondition,rowIndex,pageSize);
        int count = shopDao.queryShopCount(shopCondition);
        ShopExecution shopExecution = new ShopExecution();
        if(shopList!=null){
            shopExecution.setCount(count);
            shopExecution.setShopList(shopList);
        }else {
            shopExecution.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return shopExecution;
    }

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException {
        //控制判断
        if(shop==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            //给店铺信息赋初始值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if(effectedNum<=0){
                throw new RuntimeException("创建店铺失败");
            }else {
                if(shopImg!=null){
                    //存储图片
                    try {
                        addShopImg(shop,shopImg);
                    }catch (Exception e){
                        throw new RuntimeException("addShopImg Error"+e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if(effectedNum<=0){
                        throw new RuntimeException("更新店铺图片地址失败");
                    }
                }
            }

        }catch (Exception e){
            throw new RuntimeException("addShop Error:"+e.getMessage());
        }

        return new ShopExecution(ShopStateEnum.CHECK);
    }

    @Override
    public Shop getByShopId(long shopId) {
         return shopDao.queryByShopId(shopId);
    }

    @Override
    public ShopExecution modifyShop(Shop shop, CommonsMultipartFile shopImg, String fileName) throws ShopOperationException {
        if(shop == null||shop.getShopId()==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }else {
            try {
                //1.判断是否需要处理图片
                if (shopImg != null && fileName != null && !"".equals(fileName)) {
                    ImageUtil.deleteFileOrPath(shop.getShopImg());
                }
                addShopImg(shop, shopImg);
                //2.更新店铺信息
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {
                    return new ShopExecution(ShopStateEnum.SUCCESS, shopDao.queryByShopId(shop.getShopId()));
                }
            } catch (Exception e) {
                throw new ShopOperationException("modifyShop error" + e.getMessage());
            }

        }
    }

    public void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
        //获取shop图片目录的相对值路径
//        String os = PathUtil.getImgBasePath();
        String dest = PathUtil.getShopImagePath(shop.getShopId());
//        dest = os+dest;
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg,dest);
        shop.setShopImg(shopImgAddr);
    }
}
