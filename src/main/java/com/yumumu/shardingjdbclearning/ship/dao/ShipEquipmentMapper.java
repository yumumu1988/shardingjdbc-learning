package com.yumumu.shardingjdbclearning.ship.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yumumu.shardingjdbclearning.ship.model.po.ShipEquipmentPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhanghailin
 * @date 2022/6/2
 */
@Mapper
public interface ShipEquipmentMapper extends BaseMapper<ShipEquipmentPo> {
    default List<ShipEquipmentPo> selectByShipId(Long shipId) {
        LambdaQueryWrapper<ShipEquipmentPo> lambdaQueryWrapper = Wrappers.<ShipEquipmentPo>lambdaQuery();
        lambdaQueryWrapper.eq(ShipEquipmentPo::getShipId, shipId);
        return this.selectList(lambdaQueryWrapper);
    }
}
