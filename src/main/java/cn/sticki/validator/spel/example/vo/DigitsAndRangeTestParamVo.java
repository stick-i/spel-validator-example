package cn.sticki.validator.spel.example.vo;

import cn.sticki.spel.validator.constrain.SpelDigits;
import cn.sticki.spel.validator.constrain.SpelMax;
import cn.sticki.spel.validator.constrain.SpelMin;
import cn.sticki.spel.validator.jakarta.SpelValid;
import lombok.Data;

import java.math.BigDecimal;

/**
 * SpelDigits、SpelMax、SpelMin 新功能测试参数类
 *
 * @author 阿杆
 * @version 1.0
 * @since 2025/8/13
 */
@Data
@SpelValid
public class DigitsAndRangeTestParamVo {

    // ========== SpelDigits 测试字段 ==========

    /**
     * 基本数字位数验证 - 整数部分最多3位，小数部分最多2位
     */
    @SpelDigits(integer = "3", fraction = "2", message = "价格格式不正确，整数部分最多3位，小数部分最多2位")
    private BigDecimal price;

    /**
     * 条件数字位数验证 - 当启用精确验证时，金额整数部分最多5位，小数部分最多4位
     */
    @SpelDigits(integer = "5", fraction = "4", condition = "#this.enablePreciseValidation == true", 
                message = "精确模式下，金额格式不正确")
    private BigDecimal amount;

    /**
     * 字符串类型数字位数验证
     */
    @SpelDigits(integer = "2", fraction = "1", message = "折扣率格式不正确")
    private String discountRate;

    /**
     * 整数类型数字位数验证（无小数部分）
     */
    @SpelDigits(integer = "6", fraction = "0", message = "商品编号格式不正确，最多6位整数")
    private Integer productCode;

    // ========== SpelMax 新功能测试字段 ==========

    /**
     * CharSequence 类型最大值验证 - 字符串表示的数字不能超过100
     */
    @SpelMax(value = "100", message = "字符串表示的分数不能超过100")
    private String scoreStr;

    /**
     * CharSequence 类型最大值验证 - 字符串表示的小数不能超过1000
     */
    @SpelMax(value = "1000", message = "字符串表示的金额不能超过1000")
    private String amountStr;

    /**
     * 数值类型最大值验证 - inclusive=true（默认，包含边界值）
     */
    @SpelMax(value = "100", inclusive = true, message = "分数不能超过100分")
    private Integer score;

    /**
     * 数值类型最大值验证 - inclusive=false（不包含边界值）
     */
    @SpelMax(value = "1000", inclusive = false, message = "金额必须小于1000元")
    private BigDecimal maxAmount;

    /**
     * 条件最大值验证 - 当启用严格模式时，年龄不能超过65
     */
    @SpelMax(value = "65", condition = "#this.strictMode == true", 
             message = "严格模式下，年龄不能超过65岁")
    private Integer age;

    // ========== SpelMin 新功能测试字段 ==========

    /**
     * CharSequence 类型最小值验证 - 字符串表示的数字不能小于0
     */
    @SpelMin(value = "0", message = "字符串表示的数量不能小于0")
    private String quantityStr;

    /**
     * CharSequence 类型最小值验证 - 字符串表示的小数不能小于0.01
     */
    @SpelMin(value = "0.01", inclusive = false, message = "字符串表示的价格必须大于0.01")
    private String priceStr;

    /**
     * 数值类型最小值验证 - inclusive=true（默认，包含边界值）
     */
    @SpelMin(value = "0", inclusive = true, message = "数量不能小于0")
    private Integer quantity;

    /**
     * 数值类型最小值验证 - inclusive=false（不包含边界值）
     */
    @SpelMin(value = "0", inclusive = false, message = "价格必须大于0元")
    private BigDecimal minPrice;

    /**
     * 条件最小值验证 - 当启用年龄验证时，年龄不能小于18
     */
    @SpelMin(value = "18", condition = "#this.enableAgeValidation == true", 
             message = "启用年龄验证时，年龄不能小于18岁")
    private Integer minAge;

    // ========== 控制字段 ==========

    /**
     * 是否启用精确验证
     */
    private Boolean enablePreciseValidation;

    /**
     * 是否启用严格模式
     */
    private Boolean strictMode;

    /**
     * 是否启用年龄验证
     */
    private Boolean enableAgeValidation;

}