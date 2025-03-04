package com.nageoffer.shortlink.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ffirestorm
 * @version 1.0
 * 2025/3/4
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayErrorResult {

    /**
     * http错误码
     */
    private Integer status;

    /**
     * 错误信息
     */
    private String message;
}
