package cn.sticki.validator.spel.example.exception;

import lombok.Getter;

/**
 * 功能：业务异常
 * 详细：
 *
 * @author 黄天文
 * @since 2024/8/21
 */
@Getter
public class BusinessException extends RuntimeException {

    private int code = 200;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
