package com.gtcom.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/3 9:50
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>
{
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message)
    {
        this(code, message, null);
    }
}
