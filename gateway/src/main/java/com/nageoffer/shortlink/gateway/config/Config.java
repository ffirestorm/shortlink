package com.nageoffer.shortlink.gateway.config;

import lombok.Data;

import java.util.List;

/**
 * @author ffirestorm
 * @version 1.0
 * 2025/3/4
 *
 * 过滤器配置
 */
@Data
public class Config {

    /**
     * 白名单前置路径
     */
    private List<String> whitePathList;

}
