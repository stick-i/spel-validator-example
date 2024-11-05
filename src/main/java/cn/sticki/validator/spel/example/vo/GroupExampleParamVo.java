package cn.sticki.validator.spel.example.vo;

import cn.sticki.spel.validator.constrain.SpelNotNull;
import cn.sticki.spel.validator.javax.SpelValid;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 分组示例参数
 * <p>
 * 根据 type 的值，分别校验 textContent 和 audioContent
 * <p>
 * 当 type 为 text 时，校验 textContent 和 textContent2
 * <p>
 * 当 type 为 audio 时，校验 audioContent 和 audioContent2
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/5/4
 */
@Data
@SpelValid(spelGroups = "#this.type")
public class GroupExampleParamVo {

	@NotNull
	@Pattern(regexp = "^text|audio$")
	private String type;

	@SpelNotNull(group = Group.TEXT)
	private Object textContent;

	@SpelNotNull(group = Group.TEXT)
	private Object textContent2;

	@SpelNotNull(group = Group.AUDIO)
	private Object audioContent;

	@SpelNotNull(group = Group.AUDIO)
	private Object audioContent2;

	@SpelNotNull // 未指定分组时，默认被校验
	private Integer other;

	static class Group {

		private static final String TEXT = "'text'"; // SpEL表达式中的字符串需要使用单引号包裹，否则会被识别为变量

		private static final String AUDIO = "'audio'"; // SpEL表达式中的字符串需要使用单引号包裹，否则会被识别为变量

	}

}
