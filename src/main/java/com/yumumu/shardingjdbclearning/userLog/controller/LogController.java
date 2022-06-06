package com.yumumu.shardingjdbclearning.userLog.controller;

import com.yumumu.shardingjdbclearning.common.model.ResultData;
import com.yumumu.shardingjdbclearning.userLog.model.vo.UserLog;
import com.yumumu.shardingjdbclearning.userLog.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghailin
 * @date 2022/6/6
 */
@RestController
@RequestMapping("/logs")
public class LogController {

    @Resource
    private LogService logService;

    @GetMapping("/user/{userId}")
    public ResultData<List<UserLog>> getUserLogs(@PathVariable("userId") Long userId) {
        try {
            List<UserLog> userLogs = logService.getUserLogs(userId);
            return ResultData.success(userLogs);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.failed(e.getMessage());
        }
    }

}
