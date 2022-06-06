package com.yumumu.shardingjdbclearning.user.controller;

import com.yumumu.shardingjdbclearning.common.model.ResultData;
import com.yumumu.shardingjdbclearning.user.model.vo.UserVo;
import com.yumumu.shardingjdbclearning.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghailin
 * @date 2022/6/1
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("")
    public ResultData<UserVo> register(@RequestBody UserVo userVo) {
        try {
            return ResultData.success(userService.register(userVo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.failed(e.getMessage());
        }
    }

    /**
     * 查询用户信息
     */
    @GetMapping("/{id}")
    public ResultData<UserVo> profile(@PathVariable("id") Long id) {
        try {
            UserVo userVo = userService.getUserProfile(id);
            return ResultData.success(userVo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.failed(e.getMessage());
        }
    }

}
