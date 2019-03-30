package o2o.entity;

import java.util.Date;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-25 22:41
 */
public class ProductSellDaily {
    //哪天的销量，精确到天
    private Date creatTime;
    //销量
    private int total;
    //商品信息实体类
    private Product product;
    private Shop shop;

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
