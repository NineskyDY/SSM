package o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//因无法直接访问web-inf中的页面所以创建一个controller来转发

@Controller
@RequestMapping(value = "shopAdmin",method = {RequestMethod.GET})
public class ShopAdminCotroller {
    @RequestMapping(value = "/shopEdit")
    public String shopOperation(){
        return "shop/shopedit";
    }
    @RequestMapping(value = "/shopList")
    public String shopList(){
        return "shop/shopList";
    }
    @RequestMapping(value = "/shopManagement")
    public String shopManagement(){
        return "shop/shopManagement";
    }
    @RequestMapping(value = "/productCategoryManagement",method = {RequestMethod.GET})
    public String productCategoryManagement(){
        return "shop/productcategorymanagement";
    }
    @RequestMapping(value = "/productManagement")
    public String productManagement(){
        return "shop/productManagement";
    }
    @RequestMapping(value = "/productOperation")
    public String productOperation(){
        return "shop/productOperation";
    }

}
