package com.yumumu.shardingjdbclearning.dictionary.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yumumu.shardingjdbclearning.dictionary.model.po.DictionaryPo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zhl46
* @description 针对表【dictionary(字典定义表)】的数据库操作Mapper
* @createDate 2022-06-06 12:20:29
* @Entity generator.domain.Dictionary
*/
@Mapper
public interface DictionaryMapper extends BaseMapper<DictionaryPo> {

}




