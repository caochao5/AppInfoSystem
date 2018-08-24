package cn.zhwxjjh.yctts.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zhwxjjh.yctts.pojo.BackendUser;
import cn.zhwxjjh.yctts.pojo.DevUser;
import cn.zhwxjjh.yctts.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SysInterceptors extends HandlerInterceptorAdapter {

    private Logger logger = Logger.getLogger(SysInterceptors.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("SysInterceptors preHandle ===============");
        HttpSession session  = request.getSession();

        BackendUser backendUser = (BackendUser)session.getAttribute(Constants.USER_SESSION);
        DevUser devUser = (DevUser)session.getAttribute(Constants.DEV_USER_SESSION);

        if(backendUser != null){
            return true;
        }else if(devUser != null){
            return true;
        }else{
            response.sendRedirect(request.getContextPath()+ "/403.jsp");
            return false;
        }
    }
}
