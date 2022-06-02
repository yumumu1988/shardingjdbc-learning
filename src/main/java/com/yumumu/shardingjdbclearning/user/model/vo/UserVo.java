package com.yumumu.shardingjdbclearning.user.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghailin
 * @date 2022/6/1
 */
@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 6211866359460685307L;

    private Long userId;
    private String userName;
    private String tel;
}

