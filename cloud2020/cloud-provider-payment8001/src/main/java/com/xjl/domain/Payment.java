package com.xjl.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-08-10 17:12
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String serial;
}
