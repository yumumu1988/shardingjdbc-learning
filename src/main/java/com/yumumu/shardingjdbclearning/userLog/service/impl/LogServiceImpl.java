package com.yumumu.shardingjdbclearning.userLog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yumumu.shardingjdbclearning.userLog.dao.LogMapper;
import com.yumumu.shardingjdbclearning.userLog.model.po.Log;
import com.yumumu.shardingjdbclearning.userLog.model.vo.UserLog;
import com.yumumu.shardingjdbclearning.userLog.service.LogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author zhl46
* @description 针对表【logs(用户日志)】的数据库操作Service实现
* @createDate 2022-06-06 15:17:48
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log>
    implements LogService {

    @Override
    public List<UserLog> getUserLogs(Long userId) {
        LambdaQueryWrapper<Log> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Log::getUserid, userId);
        List<Log> logs = getBaseMapper().selectList(wrapper);
        List<UserLog> result = new ArrayList<>();
        logs.forEach(e->{
            UserLog userLog = new UserLog();
            BeanUtils.copyProperties(e, userLog);
            result.add(userLog);
        });
        return result;
    }
}




