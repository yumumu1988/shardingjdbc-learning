package com.yumumu.shardingjdbclearning.userLog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yumumu.shardingjdbclearning.userLog.model.po.Log;
import com.yumumu.shardingjdbclearning.userLog.model.vo.UserLog;

import java.util.List;

/**
* @author zhl46
* @description 针对表【logs(用户日志)】的数据库操作Service
* @createDate 2022-06-06 15:17:48
*/
public interface LogService extends IService<Log> {

    List<UserLog> getUserLogs(Long userId);
}
