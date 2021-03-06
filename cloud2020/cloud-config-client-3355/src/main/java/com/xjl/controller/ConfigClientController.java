package com.xjl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 玲
 * @Description:
 * @create 2020-09-22 9:50
 * @Modified By:
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public Map<String,String> getConfigInfo(){
        HashMap<String, String> map = new HashMap<>(16);
        map.put("info", configInfo);
        return map;
    }
}
