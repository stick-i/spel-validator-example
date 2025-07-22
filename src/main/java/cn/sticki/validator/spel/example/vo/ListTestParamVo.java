package cn.sticki.validator.spel.example.vo;

import cn.sticki.spel.validator.constrain.SpelNotEmpty;
import cn.sticki.spel.validator.constrain.SpelNotNull;
import cn.sticki.spel.validator.jakarta.SpelValid;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 功能：列表测试参数
 *
 * @author 阿杆
 * @since 2025/7/11
 */
@Data
@SpelValid
public class ListTestParamVo {

    @SpelNotNull
    private Object object;

    @Valid
    @SpelNotEmpty
    @SpelValid
    private List<InnerClass> list;

    @Data
    public static class InnerClass {

        @NotNull
        private Integer id;

        @SpelNotEmpty(condition = "#this.id > 0")
        private String name;

    }

}
