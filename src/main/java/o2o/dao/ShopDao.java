package o2o.dao;

import o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    /*
     * @description: 分页查询店铺，可输入的条件有：店铺名（模糊），店铺状态，店铺类别，区域id，owner
     * @date: 2019/2/19
     * @param：[shopCondition,查询的条件
     *          rowIndex,从第几行开始取数据
      *          pageSize]返回的条数
     * @return: java.util.List<o2o.entity.Shop>
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,@Param("rowIndex")int rowIndex,@Param("pageSize")int pageSize);

    /*
     * @description: 返回queryList的总数
     * @date: 2019/2/19
     * @param：[shopCondition]
     * @return: int
     */
    int queryShopCount(@Param("shopCondition")Shop shopCondition);
    /*
     * @description: 通过ID查询店铺
     * @author: 九霄环佩
     * @date: 2019/2/15
     * @param：[shopId]
     * @return: o2o.entity.Shop
     */
    Shop queryByShopId(long shopId);

    /*
     * 新增店铺
     * @param shop
     * @return effectedNum
     */
    int insertShop( Shop shop);

    /*
     *更新店铺信息
     */
    int updateShop(Shop shop);


}
