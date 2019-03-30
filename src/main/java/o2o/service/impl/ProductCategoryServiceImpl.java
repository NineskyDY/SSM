package o2o.service.impl;

import o2o.dao.ProductCategoryDao;
import o2o.dao.ProductDao;
import o2o.dto.ProductCategoryExecution;
import o2o.entity.ProductCategory;
import o2o.enums.ProductCategoryStateEnum;
import o2o.exceptions.ProductCategoryOperationException;
import o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-01 19:51
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryDao productCategoryDao;
    @Autowired
    ProductDao productDao;

    @Override
    public List<ProductCategory> getProductCategoryList(Long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }


    @Transactional
    @Override
    public ProductCategoryExecution BatchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException {
        if(productCategoryList!=null&&productCategoryList.size()>0){
            try {
                int effectNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
                if(effectNum>0){
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }else {
                    throw new ProductCategoryOperationException("创建店铺类别失败");
                }
            }catch (Exception e){
                throw new ProductCategoryOperationException("BatchAddProductCategory error:"+e.getMessage());
            }
        }else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }

    }

    @Override
    @Transactional
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException {
        // 将此类别下的商品id置为空
        try {
            int effectNum = productDao.updateProductCategoryToNull(productCategoryId);
            if(effectNum < 1){
                throw new ProductCategoryOperationException("解绑该类别商品失败");
            }
        }catch (Exception e){
            throw new ProductCategoryOperationException("deleteProductCategory error" + e.getMessage());
        }
        //删除该ProductCategory
        try {
            int effectNum = productCategoryDao.deleteProductCategory(productCategoryId,shopId);
            if(shopId > 0){
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }else {
                throw  new ProductCategoryOperationException("删除失败");
            }
        }catch (Exception e){
            throw new ProductCategoryOperationException("deleteProductCategory error"+e.getMessage());
        }
    }
}
