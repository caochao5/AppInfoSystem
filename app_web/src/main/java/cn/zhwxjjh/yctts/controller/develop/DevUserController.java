package cn.zhwxjjh.yctts.controller.develop;

import cn.zhwxjjh.yctts.pojo.DevUser;
import cn.zhwxjjh.yctts.service.developer.DevUserService;
import cn.zhwxjjh.yctts.utils.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/dev")
public class DevUserController {

    @Autowired
    private DevUserService service;

    private Logger logger = Logger.getLogger(DevUserController.class);

    @RequestMapping(value="/login")
    public String login(){
        logger.debug("loginController welcome AppInfoSystem devUser=====");
        return "devlogin";
    }

    @RequestMapping(value="/doLogin")
    public String doLogin(String devCode, String password,
                          HttpSession session, HttpServletRequest request){
        logger.debug("doLogin=============");
        DevUser devUser=null;
        devUser = service.login(devCode,password);
        if(devUser != null){
            //user放入session
            session.setAttribute(Constants.DEV_USER_SESSION,devUser);
            //重定向到主页面
            return "redirect:/dev/flatform/main";
        }else{
            request.setAttribute("error","用户名或密码不正确");
            return "devlogin";
        }
    }

    @RequestMapping(value="/flatform/main")
    public String main(HttpSession session){
        if(session.getAttribute(Constants.DEV_USER_SESSION) != null){
            return "developer/main";
        }
        return "redirect:/dev/login";
    }

    @RequestMapping(value="/loginOut")
    public String loignOut(HttpSession session){
        session.removeAttribute(Constants.DEV_USER_SESSION);
        return "devlogin";
    }
}
