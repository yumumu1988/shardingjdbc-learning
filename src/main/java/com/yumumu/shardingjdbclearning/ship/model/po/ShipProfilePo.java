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
@TableName("ship_profile")
public class ShipProfilePo implements Serializable {
    private static final long serialVersionUID = -7351475671817547142L;

    @TableId
    private Long shipProfileId;
    private Integer level;
    private Integer victory;
    private Integer defeat;
    private String description;
    private Long shipId;
    private Long userId;
}
