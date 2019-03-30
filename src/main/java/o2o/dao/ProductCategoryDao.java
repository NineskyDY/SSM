package o2o.dao;

import o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-02-26 18:06
 */
public interface ProductCategoryDao {
    /*
     * @description:
     * @date: 2019/2/26
     * @param：
     * @return:
     */
    List<ProductCategory> queryProductCategoryList(Long shopId);

    /*
     * @description: 批量新增商品类别
     * @date: 2019/3/2
     * @param：[productCategoryList]
     * @return: int
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /*
     * @description: 删除指定商品类别
     * @date: 2019/3/2
     * @param：[productCategoryId, shopId]
     * @return: int
     */
    int deleteProductCategory(@Param("productCategoryId")long productCategoryId,@Param("shopId")long shopId);
}
