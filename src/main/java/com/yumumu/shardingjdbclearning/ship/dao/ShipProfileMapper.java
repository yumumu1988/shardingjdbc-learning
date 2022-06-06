package com.yumumu.shardingjdbclearning.ship.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yumumu.shardingjdbclearning.ship.model.po.ShipProfilePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhanghailin
 * @date 2022/6/2
 */
@Mapper
public interface ShipProfileMapper extends BaseMapper<ShipProfilePo> {

    @Select("select p.* from ships s left join ship_profile p on s.ship_id = p.ship_id where s.ship_id = #{shipId}")
    ShipProfilePo selectProfileByShipId(@Param("shipId") Long shipId);

}
