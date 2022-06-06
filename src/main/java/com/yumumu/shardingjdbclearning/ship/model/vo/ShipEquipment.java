package com.yumumu.shardingjdbclearning.ship.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghailin
 * @date 2022/6/2
 */
@Data
public class ShipEquipment implements Serializable {
    private static final long serialVersionUID = -6821584316022577930L;

    private Long shipEquipmentId;
    private Long shipId;
    private Long userId;
    private Integer type;
    private String name;
    private Integer status;

}
