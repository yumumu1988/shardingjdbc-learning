package com.yumumu.shardingjdbclearning.userLog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yumumu.shardingjdbclearning.userLog.model.po.Log;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zhl46
* @description 针对表【logs(用户日志)】的数据库操作Mapper
* @createDate 2022-06-06 15:17:48
* @Entity generator.domain.Log
*/
@Mapper
public interface LogMapper extends BaseMapper<Log> {

}




