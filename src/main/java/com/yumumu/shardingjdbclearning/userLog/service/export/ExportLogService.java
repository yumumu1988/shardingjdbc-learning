package com.yumumu.shardingjdbclearning.userLog.service.export;

import com.yumumu.shardingjdbclearning.userLog.dao.LogMapper;
import com.yumumu.shardingjdbclearning.userLog.model.po.Log;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhanghailin
 * @date 2022/6/6
 */
@Service
public class ExportLogService {

    @Resource
    private LogMapper logMapper;

    public void addLog(Long userId, String content) {
        Log log = new Log();
        log.setUserid(userId);
        log.setContent(content);
        logMapper.insert(log);
    }

}
