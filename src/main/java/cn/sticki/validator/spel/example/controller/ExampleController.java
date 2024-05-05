package cn.sticki.validator.spel.example.controller;

import cn.sticki.validator.spel.example.advice.Resp;
import cn.sticki.validator.spel.example.vo.GroupExampleParamVo;
import cn.sticki.validator.spel.example.vo.SimpleExampleParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

}
