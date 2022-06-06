package com.yumumu.shardingjdbclearning.ship.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghailin
 * @date 2022/6/2
 */
@Data
@TableName("ship_equipment")
public class ShipEquipmentPo implements Serializable {
    private static final long serialVersionUID = 5215051781367009915L;

    @TableId
    private Long shipEquipmentId;
    private Long shipId;
    private Long userId;
    private Integer type;
    private String name;
    private Integer status;
}
