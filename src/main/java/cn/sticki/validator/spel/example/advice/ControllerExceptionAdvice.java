package cn.sticki.validator.spel.example.advice;

import cn.sticki.validator.spel.example.exception.BusinessException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * SpringMVC的异常处理器
 *
 * @author 阿杆
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {

	@ExceptionHandler(Throwable.class)
	public Resp<Void> handleUnknownException(Throwable ex) {
		log.error(ex.getMessage(), ex);
		return new Resp<>(500, ex.getMessage());
	}

	@ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
	public Resp<Void> handleBindException(BindException ex) {
		String msg = ex.getFieldErrors().stream()
				.map(error -> error.getField() + " " + error.getDefaultMessage())
				.reduce((s1, s2) -> s1 + "," + s2)
				.orElse("");
		return new Resp<>(400, msg);
	}

	@ExceptionHandler({BusinessException.class})
	public Resp<Void> handleBusinessException(BusinessException ex) {
		return new Resp<>(ex.getCode(), ex.getMessage());
	}

	/**
	 * 针对业务异常进行处理
	 * <p>
	 * <a href="https://github.com/stick-i/spel-validator/issues/19">参见GitHub issue</a>
	 */
	@ExceptionHandler({ValidationException.class})
	public Resp<Void> handleValidationException(ValidationException ex) {
		if (ex.getCause() instanceof BusinessException) {
			return handleBusinessException((BusinessException) ex.getCause());
		}
		return new Resp<>(500, "system error");
	}

}
