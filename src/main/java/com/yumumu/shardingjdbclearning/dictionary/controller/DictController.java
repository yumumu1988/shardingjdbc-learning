package com.yumumu.shardingjdbclearning.dictionary.controller;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.yumumu.shardingjdbclearning.common.model.ResultData;
import com.yumumu.shardingjdbclearning.dictionary.model.po.DictionaryPo;
import com.yumumu.shardingjdbclearning.dictionary.model.vo.Dictionary;
import com.yumumu.shardingjdbclearning.dictionary.service.DictionaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghailin
 * @date 2022/6/6
 */
@RestController
@RequestMapping("/dict")
public class DictController {

    @Resource
    private DictionaryService dictionaryService;

    @GetMapping({"", "/"})
    public ResultData<List<Dictionary>> getAll() {
        try {

            List<Dictionary> list = new ArrayList<>();
            List<DictionaryPo> dictionaryPos = dictionaryService.getAll();
            dictionaryPos.forEach(e->{
                Dictionary dictionary = new Dictionary();
                BeanUtils.copyProperties(e, dictionary);
                list.add(dictionary);
            });
            return ResultData.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.failed(e.getMessage());
        }
    }

}
