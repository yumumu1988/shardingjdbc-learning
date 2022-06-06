package com.yumumu.shardingjdbclearning.dictionary.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 字典定义表
 * @TableName dictionary
 */
@TableName(value ="dictionary")
@Data
public class DictionaryPo implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 字典类型名称
     */
    private String type;

    /**
     * 字典键
     */
    @TableField("index_key")
    private Integer indexKey;

    /**
     * 字典值
     */
    private String value;

    /**
     * 启用状态
     */
    private Integer enable;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DictionaryPo other = (DictionaryPo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIndexKey() == null ? other.getIndexKey() == null : this.getIndexKey().equals(other.getIndexKey()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((this.getIndexKey() == null) ? 0 : this.getIndexKey().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", key=").append(indexKey);
        sb.append(", value=").append(value);
        sb.append(", enable=").append(enable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}