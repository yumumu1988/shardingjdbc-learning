package com.yumumu.shardingjdbclearning.user.service;

import com.yumumu.shardingjdbclearning.user.dao.UserMapper;
import com.yumumu.shardingjdbclearning.user.model.po.UserPo;
import com.yumumu.shardingjdbclearning.user.model.vo.UserVo;
import com.yumumu.shardingjdbclearning.userLog.service.export.ExportLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhanghailin
 * @date 2022/6/1
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ExportLogService logService;

    public UserVo register(UserVo userVo) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userVo, userPo);
        userMapper.insert(userPo);
        userVo.setUserId(userPo.getUserId());
        logService.addLog(userPo.getUserId(), "注册用户");
        return userVo;
    }

    public UserVo getUserProfile(Long id) {
        UserPo userPo = userMapper.selectById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userPo, userVo);
        return userVo;
    }
}
