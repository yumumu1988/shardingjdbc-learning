package com.yumumu.shardingjdbclearning.dictionary.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.yumumu.shardingjdbclearning.dictionary.dao.DictionaryMapper;
import com.yumumu.shardingjdbclearning.dictionary.model.po.DictionaryPo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author zhl46
* @description 针对表【dictionary(字典定义表)】的数据库操作Service实现
* @createDate 2022-06-06 12:20:29
*/
@Service
public class DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    public List<DictionaryPo> getAll() {
        LambdaQueryWrapper<DictionaryPo> wrapper = Wrappers.<DictionaryPo>lambdaQuery();
        wrapper.eq(DictionaryPo::getEnable, 1);
        return dictionaryMapper.selectList(wrapper);
    }
}




