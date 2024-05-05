package cn.sticki.validator.spel.example.advice;

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

}
