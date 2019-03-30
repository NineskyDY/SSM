package o2o.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import o2o.entity.ShopCategory;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-02-09 17:05
 */
public interface ShopCategoryService {
     String SCLISTKEY = "shopcategorylist";
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) throws IOException;
}
