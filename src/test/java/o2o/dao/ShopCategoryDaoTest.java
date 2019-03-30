package o2o.dao;

import o2o.BaseTest;
import o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-02-09 17:34
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void  testQueryShopCategory(){

        System.out.println(shopCategoryDao);
        ShopCategory shopCategory = new ShopCategory();
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(shopCategory);
        System.out.println(shopCategoryList);
        assertEquals(12,shopCategoryList.size());
    }



}
