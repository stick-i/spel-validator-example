package cn.sticki.validator.spel.example.vo;

import cn.sticki.spel.validator.constrain.*;
import cn.sticki.spel.validator.javax.SpelValid;
import lombok.Data;

/**
 * 注解测试参数
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/5/9
 */
@Data
@SpelValid
public class AnnoTestParamVo {

	private Boolean checkAssert;

	@SpelAssert(condition = "#this.checkAssert == true", assertTrue = "T(cn.sticki.validator.spel.example.enums.ExampleEnum).getByCode(#this.testSpelAssert) != null", message = "test值不合法")
	private Integer testSpelAssert;

	private Boolean checkNotBlank;

	@SpelNotBlank(condition = "#this.checkNotBlank == true", message = "test字符串不能为空")
	private String testSpelNotBlank;

	private Boolean checkNotEmpty;

	@SpelNotEmpty(condition = "#this.checkNotEmpty == true", message = "test集合不能为空")
	private String testSpelNotEmpty;

	private Boolean checkNotNull;

	@SpelNotNull(condition = "#this.checkNotNull == true", message = "test对象不能为null")
	private Object testSpelNotNull;

	private Boolean checkNull;

	@SpelNull(condition = "#this.checkNull == true", message = "test对象必须为null")
	private Object testSpelNull;

	private Boolean checkSize;

	@SpelSize(condition = "#this.checkSize == true", min = "1 + 1", max = "10 + 10", message = "test 长度必须在 {min} 和 {max} 之间")
	private String testSpelSize;

}
