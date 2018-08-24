package cn.zhwxjjh.yctts.service.developer;

import cn.zhwxjjh.yctts.pojo.DevUser;

public interface DevUserService {

    /**
     * 登录验证
     * @param devCode
     * @param password
     * @return
     */
    public DevUser login(String devCode,String password);
}
