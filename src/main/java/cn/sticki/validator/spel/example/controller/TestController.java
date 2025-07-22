package cn.sticki.validator.spel.example.controller;

import cn.sticki.validator.spel.example.advice.Resp;
import cn.sticki.validator.spel.example.vo.AnnoTestParamVo;
import cn.sticki.validator.spel.example.vo.ListTestParamVo;
import cn.sticki.validator.spel.example.vo.TimeDateTestParamVo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/anno")
	public Resp<Void> annoTest(@RequestBody @Valid AnnoTestParamVo annoTestParamVo) {
		log.info("annoTest");
		return Resp.ok();
	}

	/**
	 * 列表测试
	 * <p>
	 * 测试列表参数的校验
	 */
	@PostMapping("/list")
	public Resp<Void> listTest(@RequestBody @Valid ListTestParamVo paramVo) {
		log.info("ListTest");
		return Resp.ok();
	}

	/**
	 * 时间日期测试
	 */
	@PostMapping("/timeDate")
	public Resp<Void> timeDateTest(@RequestBody @Valid TimeDateTestParamVo paramVo) {
		log.info("timeDateTest");
		return Resp.ok();
	}

}
