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
@TableName("ships")
public class ShipPo implements Serializable {
    private static final long serialVersionUID = 1219468998840749600L;

    @TableId
    private Long shipId;
    private Long userId;
    private Integer type;
    private String shipName;
    private Integer status;
}
