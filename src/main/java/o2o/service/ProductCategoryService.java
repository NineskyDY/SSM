package o2o.service;

import o2o.dto.ProductCategoryExecution;
import o2o.entity.ProductCategory;
import o2o.exceptions.ProductCategoryOperationException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-01 19:48
 */
public interface ProductCategoryService {

    /*
     * @description: 
     * @date: 2019/3/1
     * @param：[shopId]
     * @return: java.util.List<o2o.entity.ProductCategoryService>
     */
    List<ProductCategory> getProductCategoryList(Long shopId);

    ProductCategoryExecution BatchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;

    /*
     * @description: 将此类别下的商品id置为空，再删除掉该商品类别
     * @date: 2019/3/2
     * @param：[productCategoryId, shopId]
     * @return: o2o.dto.ProductCategoryExecution
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId,long shopId) throws ProductCategoryOperationException;

}
