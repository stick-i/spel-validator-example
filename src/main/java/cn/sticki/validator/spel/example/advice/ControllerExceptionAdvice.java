package cn.sticki.validator.spel.example.advice;

import cn.sticki.validator.spel.example.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
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
		log.error(ex.getMessage(), ex);
		return new Resp<>(500, "system error");
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public Resp<Void> handleConstraintViolationException(HttpServletRequest request, ConstraintViolationException ex) {
		String msg = ex.getConstraintViolations().stream()
				.map(violation -> {
					// 处理带有属性路径的约束异常，由于客户端不需要知道完整的属性路径，所以只返回最后一个属性名
					String originalPath = violation.getPropertyPath().toString();
					// 找到最后一个点号的位置，提取点号后面的部分
					int dotIndex = originalPath.lastIndexOf('.');
					if (dotIndex != -1 && dotIndex < originalPath.length() - 1) {
						return originalPath.substring(dotIndex + 1) + " " + violation.getMessage();
					}
					return originalPath + " " + violation.getMessage();
				})
				.reduce((s1, s2) -> s1 + "; " + s2)
				.orElse("");
		return new Resp<>(400, msg);
	}

}
