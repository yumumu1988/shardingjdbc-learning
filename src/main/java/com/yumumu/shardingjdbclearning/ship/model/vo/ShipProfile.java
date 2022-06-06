package com.yumumu.shardingjdbclearning.ship.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghailin
 * @date 2022/6/2
 */
@Data
public class ShipProfile implements Serializable {
    private static final long serialVersionUID = -7351475671817547142L;

    private Long shipProfileId;
    private Integer level;
    private Integer victory;
    private Integer defeat;
    private String description;
    private Long shipId;
    private Long userId;
}
