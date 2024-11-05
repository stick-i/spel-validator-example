package cn.sticki.validator.spel.example.controller;

import cn.sticki.spel.validator.core.SpelValidExecutor;
import cn.sticki.spel.validator.core.result.ObjectValidResult;
import cn.sticki.validator.spel.example.advice.Resp;
import cn.sticki.validator.spel.example.vo.GroupExampleParamVo;
import cn.sticki.validator.spel.example.vo.SimpleExampleParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

/**
 * 示例接口集合
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/5/1
 */
@Slf4j
@RestController
@RequestMapping("/example")
public class ExampleController {

	/**
	 * 简单校验示例
	 */
	@PostMapping("/simple")
	public Resp<Void> simple(@RequestBody @Valid SimpleExampleParamVo simpleExampleParamVo) {
		log.info("simple");
		return Resp.ok(null);
	}

	/**
	 * 分组校验示例
	 */
	@PostMapping("/group")
	public Resp<Void> group(@RequestBody @Valid GroupExampleParamVo groupExampleParamVo) {
		log.info("group");
		return Resp.ok(null);
	}

	/**
	 * 静态方法校验
	 * <p>
	 * 通过 {@link  SpelValidExecutor#validateObject(Object, Set)} 进行校验，这种方式仅校验 {@link cn.sticki.spel.validator.constrain} 包下的注解
	 */
	@PostMapping("/static")
	public Resp<ObjectValidResult> staticTest(@RequestBody SimpleExampleParamVo simpleExampleParamVo) {
		ObjectValidResult validResult = SpelValidExecutor.validateObject(simpleExampleParamVo);
		return Resp.ok(validResult);
	}

}
