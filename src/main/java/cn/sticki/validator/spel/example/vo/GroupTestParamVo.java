package cn.sticki.validator.spel.example.vo;

import cn.sticki.spel.validator.constrain.SpelNotNull;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 分组测试参数
 *
 * @author 阿杆
 * @since 2025/2/10
 */
@Data
public class GroupTestParamVo {

    @SpelNotNull(group = {Group.UPDATE})
    private Integer id;

    @SpelNotNull(group = {Group.UPDATE, Group.ADD})
    private String name;

    @NotNull
    private String phone;

    public static class Group {

        public static final String ADD = "'add'"; // SpEL表达式中的字符串需要使用单引号包裹，否则会被识别为变量

        public static final String UPDATE = "'audio'";

    }

}
