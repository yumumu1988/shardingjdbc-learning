package com.yumumu.shardingjdbclearning.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yumumu.shardingjdbclearning.user.model.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanghailin
 * @date 2022/6/1
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPo> {
}
