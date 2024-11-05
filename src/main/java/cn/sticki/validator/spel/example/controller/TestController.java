package cn.sticki.validator.spel.example.controller;

import cn.sticki.validator.spel.example.advice.Resp;
import cn.sticki.validator.spel.example.vo.AnnoTestParamVo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用例接口
 * <p>
 * <a href="https://spel-validator.apifox.cn/">接口文档地址</a>
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/5/9
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

	/**
	 * 注解测试
	 */
	@RequestMapping("/anno")
	public Resp<Void> annoTest(@RequestBody @Valid AnnoTestParamVo annoTestParamVo) {
		log.info("annoTest");
		return Resp.ok(null);
	}

}
