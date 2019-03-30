package o2o.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import o2o.cache.JedisUtil;
import o2o.dao.ShopCategoryDao;
import o2o.entity.HeadLine;
import o2o.entity.ShopCategory;
import o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-02-09 17:07
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Autowired
    private JedisUtil.Keys jedisKey;
    @Autowired
    private JedisUtil.Strings jedisString;



    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) throws IOException {
        String key = SCLISTKEY;
        List<ShopCategory > shopCategoryList = null;
        ObjectMapper mapper = new ObjectMapper();
        if(shopCategoryCondition==null){
//          若查询条件为空，列出所有的首页大类，即parentId为空的店铺类别
            key = key+"_allfirstlevel";
        }else if(shopCategoryCondition!=null&&shopCategoryCondition.getShopCategoryId()!=null&&shopCategoryCondition.getParent().getShopCategoryId()!=null){
//            若父类不为空，列出该parentId下所有的子类型
            key = key+"_parent"+shopCategoryCondition.getParent().getShopCategoryId();
        }else if (shopCategoryCondition!=null){
//            //列出所有的类别
            key = key+"_allsecondlevel";
        }
        if(jedisKey.exists(key)){
            shopCategoryList = shopCategoryDao.queryShopCategory(shopCategoryCondition);
            String jsonString = mapper.writeValueAsString(shopCategoryList);
            jedisString.set(key,jsonString);
        }else {
            String jsonString = jedisString.get(key);
            JavaType javaType = mapper.getTypeFactory()
                    .constructParametricType(ArrayList.class, ShopCategory.class);
            shopCategoryList = mapper.readValue(jsonString, javaType);
        }
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
