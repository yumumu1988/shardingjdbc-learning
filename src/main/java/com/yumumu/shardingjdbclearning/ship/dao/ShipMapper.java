package com.yumumu.shardingjdbclearning.ship.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yumumu.shardingjdbclearning.ship.model.po.ShipPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanghailin
 * @date 2022/6/2
 */
@Mapper
public interface ShipMapper extends BaseMapper<ShipPo> {
}
