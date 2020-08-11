package com.xjl.domain;

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
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String serial;
}
