package com.yumumu.shardingjdbclearning.ship.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanghailin
 * @date 2022/6/2
 */
@Data
public class ShipInfo implements Serializable {
    private static final long serialVersionUID = 2184032972645537544L;

    private Long shipId;
    private Long userId;
    private Integer type;
    private String shipName;
    private Integer status;

    private List<ShipEquipment> shipEquipments;

    private ShipProfile shipProfile;

}
