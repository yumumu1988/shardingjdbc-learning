package com.yumumu.shardingjdbclearning.user.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghailin
 * @date 2022/6/1
 */
@TableName("user")
@Data
public class UserPo implements Serializable {

    private static final long serialVersionUID = -4575122707530511962L;
    @TableId
    private Long userId;
    private String userName;
    private String tel;
}
