package cn.sticki.validator.spel.example.vo;

import cn.sticki.spel.validator.constrain.SpelAssert;
import cn.sticki.spel.validator.constrain.SpelNotNull;
import cn.sticki.spel.validator.jakarta.SpelValid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 测试参数
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/5/1
 */
@Data
@SpelValid
public class SimpleExampleParamVo {

	@NotNull
	private Boolean switchAudio;

	/**
	 * 当 switchAudio 为 true 时，校验 audioContent，audioContent 不能为null
	 */
	@SpelNotNull(condition = "#this.switchAudio == true", message = "语音内容不能为空")
	private Object audioContent;

	/**
	 * 枚举值校验
	 * <p>
	 * 通过静态方法调用，校验枚举值是否存在
	 */
	@SpelAssert(assertTrue = " T(cn.sticki.validator.spel.example.enums.ExampleEnum).getByCode(#this.testEnum) != null ", message = "枚举值不合法")
	private Integer testEnum;

	/**
	 * 调用Spring Bean进行验证
	 */
	@SpelAssert(assertTrue = "@exampleService.getUser(#this.userId) != null", message = "用户不存在")
	private Integer userId;

}
