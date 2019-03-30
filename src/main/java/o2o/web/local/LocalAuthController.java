package o2o.web.local;

import o2o.dto.LocalAuthExecution;
import o2o.entity.LocalAuth;
import o2o.entity.PersonInfo;
import o2o.enums.LocalAuthStateEnum;
import o2o.exceptions.LocalAuthOperationException;
import o2o.service.LocalAuthService;
import o2o.util.CodeUtil;
import o2o.util.HttpServletRequestUtil;
import o2o.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-23 21:18
 */
@Controller
@RequestMapping(value = "/local", method = {RequestMethod.POST,RequestMethod.GET})
public class LocalAuthController {
    @Autowired
    private LocalAuthService localAuthService;

    @RequestMapping(value = "/bindLocalAuth", method = RequestMethod.POST)
    @ResponseBody
    /*
     * 将用户信息与平台绑定
     */
    private Map<String, Object> bindLocalAuth(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
//        验证码校验
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "验证码错误");
            return modelMap;
        }
        String userName = HttpServletRequestUtil.getString(request, "userName");
        String password = HttpServletRequestUtil.getString(request, "password");
        PersonInfo user = (PersonInfo)request.getSession().getAttribute("user");
        if (userName != null && password != null && user!=null && user.getUserId()!=null){
            LocalAuth localAuth = new LocalAuth();
            localAuth.setUserName(userName);
            localAuth.setPassword(password);
            localAuth.setPersonInfo(user);
            //绑定账号
            LocalAuthExecution localAuthExecution = localAuthService.bindLocalAuth(localAuth);
            if(localAuthExecution.getState()== LocalAuthStateEnum.SUCCESS.getState()){
                modelMap.put("success", true);
            }else {
                modelMap.put("success", false);
                modelMap.put("errMsg", localAuthExecution.getStateInfo());
            }
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg","用户名 密码不能为空" );
        }
        return modelMap;
    }

    @RequestMapping(value = "/ChangeLocalPwd", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> ChangeLocalPwd(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //验证码校验
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "验证码错误");
            return modelMap;
        }
        String userName = HttpServletRequestUtil.getString(request, "userName");
        String password = HttpServletRequestUtil.getString(request, "password");
        String newPassword = HttpServletRequestUtil.getString(request, "newPassword");
        PersonInfo user = (PersonInfo)request.getSession().getAttribute("user");
        if (userName != null && password != null && user!=null && user.getUserId()!=null
                && newPassword != null && !password.equals(newPassword)) {
            try {
                //查看原账号与输入账号是否一致，不一致则认为是非法操作
                LocalAuth localAuth = localAuthService.getLocalAuthByUserId(user.getUserId());
                if(localAuth==null||!localAuth.getUserName().equals(userName))
                {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", "输入账号非本次输入账号");
                    return modelMap;
                }
                //修改密码
                LocalAuthExecution localAuthExecution = localAuthService.modifyLocalAuth(user.getUserId(),userName,password,newPassword);
                if(localAuthExecution.getState()== LocalAuthStateEnum.SUCCESS.getState()){
                    modelMap.put("success", true);
                }else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", localAuthExecution.getStateInfo());
                }
            }catch (LocalAuthOperationException e){
                modelMap.put("success", false);
                modelMap.put("errMsg",e.toString());
                return modelMap;
            }
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg","账号密码未输入或新密码与原密码相同");
        }
        return modelMap;
    }
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> loginCheck(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //获取是否要进行验证码校验的标识符
        boolean needVerify = HttpServletRequestUtil.getBoolean(request,"needVerify");
        if(needVerify&&!CodeUtil.checkVerifyCode(request)){
            modelMap.put("success", false);
            modelMap.put("errMsg", "验证码错误");
            return modelMap;
        }
        String userName = HttpServletRequestUtil.getString(request, "userName");
        String password = HttpServletRequestUtil.getString(request, "password");
        if (userName != null && password != null) {
//            password = MD5.getMd5(password);
            LocalAuth localAuth = localAuthService
                    .getLocalAuthByUserNameAndPwd(userName, password);
            if (localAuth != null) {
//                if (localAuth.getPersonInfo().getAdminFlag() == 1) {
//                    modelMap.put("success", true);
//                    request.getSession().setAttribute("user",
//                            localAuth.getPersonInfo());
//                } else {
//                    modelMap.put("success", false);
//                    modelMap.put("errMsg", "非管理员没有权限访问");
//                }
                modelMap.put("success", true);
                request.getSession().setAttribute("user", localAuth.getPersonInfo());
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "用户名或密码错误");
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "用户名和密码均不能为空");
        }
        return modelMap;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    //当用户点击退出登陆按钮是注销session
    private Map<String, Object> logout(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        request.getSession().setAttribute("user",null);
        modelMap.put("success",true);
        return modelMap;
    }
}

