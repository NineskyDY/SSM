package o2o.dao;

import o2o.BaseTest;
import o2o.entity.ProductCategory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-02-26 18:16
 */
//jUnit测试顺序随机，加入@FixMethodOrder(MethodSorters.NAME_ASCENDING)按名称顺序执行，其他两种分别为随机和jvm接受顺序，一般不用
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    ProductCategoryDao productCategoryDao;

    @Ignore
    @Test
    public void testqueryProductCategoryListTest(){
        Long shopId = 20L;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println(productCategoryList.size());
    }

    @Ignore
    @Test
    public void testBatchInsertProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCreateTime(new Date());
        productCategory.setPriority(55);
        productCategory.setProductCategoryName("test1");
        productCategory.setShopId(20L);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCreateTime(new Date());
        productCategory1.setPriority(65);
        productCategory1.setProductCategoryName("test2");
        productCategory1.setShopId(20L);
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory1);
        int i = productCategoryDao.batchInsertProductCategory(productCategoryList);
        System.out.println(i);
    }

    @Test
    public void testDeleteProductCategory() throws Exception{
        Long shopId = 20L;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        for (ProductCategory productCategory:productCategoryList){
            if("test1".equals(productCategory.getProductCategoryName())||"test2".equals(productCategory.getProductCategoryName())){
                int effectNum = productCategoryDao.deleteProductCategory(productCategory.getProductCategoryId(),shopId);
                System.out.println(effectNum);
            }
        }
    }
}
