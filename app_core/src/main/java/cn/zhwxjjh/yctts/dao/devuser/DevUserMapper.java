package cn.zhwxjjh.yctts.dao.devuser;

import cn.zhwxjjh.yctts.pojo.DevUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DevUserMapper {

    /**
     * 根据devCode获取用户记录
     * @param devCode
     * @return
     */
    public DevUser getLoginUser(@Param("devCode") String devCode);
}
