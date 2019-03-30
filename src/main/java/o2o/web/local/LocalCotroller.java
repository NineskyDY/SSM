package o2o.web.local;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-23 22:13
 */
@Controller
@RequestMapping("/local")
public class LocalCotroller {
//    绑定账号页路由
    @RequestMapping(value = "/accountBind",method = RequestMethod.GET)
    private String accountBind(){
        return "/local/accountBind";
    }

    //登陆页路由
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    private String login(){
        return "/local/login";
    }
}
