package cn.uppp.java.core.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一结果返回类
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 4647208641587608105L;
    private Integer code;
    private String msg;
    private T data;
}
