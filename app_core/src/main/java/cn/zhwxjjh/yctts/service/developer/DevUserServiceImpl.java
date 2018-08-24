package cn.zhwxjjh.yctts.service.developer;

import cn.zhwxjjh.yctts.dao.devuser.DevUserMapper;
import cn.zhwxjjh.yctts.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserMapper mapper;
    @Override
    public DevUser login(String devCode, String password) {
        DevUser user=null;
        user = mapper.getLoginUser(devCode);
        if(user != null){
            if (!user.getDevPassword().equals(password)) {
                user = null;
            }
        }
        return user;
    }
}
