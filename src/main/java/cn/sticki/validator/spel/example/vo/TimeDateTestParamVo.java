package cn.sticki.validator.spel.example.vo;

import cn.sticki.spel.validator.constrain.SpelFuture;
import cn.sticki.spel.validator.constrain.SpelFutureOrPresent;
import cn.sticki.spel.validator.constrain.SpelPast;
import cn.sticki.spel.validator.constrain.SpelPastOrPresent;
import cn.sticki.spel.validator.jakarta.SpelValid;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 时间日期约束注解使用示例
 * <p>
 * 这个类展示了如何使用新实现的四个时间约束注解：
 * - @SpelFuture: 验证时间必须是未来时间
 * - @SpelFutureOrPresent: 验证时间必须是未来或当前时间
 * - @SpelPast: 验证时间必须是过去时间
 * - @SpelPastOrPresent: 验证时间必须是过去或当前时间
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/12/21
 */
@Data
@SpelValid
public class TimeDateTestParamVo {

    // ========== 基本用法示例 ==========

    /**
     * 生日必须是过去的日期
     */
    @SpelPast
    private LocalDate birthday;

    /**
     * 会议开始时间必须是未来时间
     */
    @SpelFuture
    private LocalDateTime meetingStartTime;

    /**
     * 项目截止日期必须是未来或当前日期
     */
    @SpelFutureOrPresent
    private LocalDate projectDeadline;

    /**
     * 最后登录时间必须是过去或当前时间
     */
    @SpelPastOrPresent
    private Date lastLoginTime;

    // ========== 条件验证示例 ==========

    private boolean enableTimeValidation;

    /**
     * 只有当启用时间验证时，才验证预约时间必须是未来时间
     */
    @SpelFuture(condition = "#this.enableTimeValidation == true")
    private LocalDateTime appointmentTime;

    /**
     * 只有当启用时间验证时，才验证创建时间必须是过去时间
     */
    @SpelPast(condition = "#this.enableTimeValidation")
    private LocalDateTime createdTime;

    // ========== 重复注解示例 ==========

    private boolean strictMode;

    private boolean businessHours;

    /**
     * 使用重复注解进行多重验证：
     * 1. 在严格模式下，事件时间必须是未来时间
     * 2. 在工作时间模式下，事件时间也必须是未来时间
     */
    @SpelFuture(condition = "#this.strictMode", message = "在严格模式下，事件时间必须是未来时间")
    @SpelFuture(condition = "#this.businessHours", message = "在工作时间模式下，事件时间必须是未来时间")
    private LocalDateTime eventTime;

    // ========== 支持的时间类型示例 ==========

    /**
     * 支持 java.util.Date
     */
    @SpelFuture
    private Date futureUtilDate;

    /**
     * 支持 java.time.LocalDate
     */
    @SpelPast
    private LocalDate pastLocalDate;

    /**
     * 支持 java.time.LocalDateTime
     */
    @SpelFutureOrPresent
    private LocalDateTime futureOrPresentLocalDateTime;

    /**
     * 支持 java.time.Instant
     */
    @SpelPastOrPresent
    private java.time.Instant pastOrPresentInstant;

    /**
     * 支持 java.time.OffsetDateTime
     */
    @SpelFuture
    private java.time.OffsetDateTime futureOffsetDateTime;

    /**
     * 支持 java.time.ZonedDateTime
     */
    @SpelPast
    private java.time.ZonedDateTime pastZonedDateTime;

    /**
     * 支持 java.time.Year
     */
    @SpelFutureOrPresent
    private java.time.Year futureOrPresentYear;

    /**
     * 支持 java.time.YearMonth
     */
    @SpelPastOrPresent
    private java.time.YearMonth pastOrPresentYearMonth;

    /**
     * 支持 java.util.Calendar
     */
    @SpelFuture
    private java.util.Calendar futureCalendar;

    // ========== 自定义错误消息示例 ==========

    /**
     * 自定义错误消息
     */
    @SpelFuture(message = "会议时间必须安排在未来")
    private LocalDateTime customMessageMeetingTime;

    /**
     * 使用国际化消息键
     */
    @SpelPast(message = "{custom.past.validation.message}")
    private LocalDate customI18nPastDate;

    // ========== 复杂业务场景示例 ==========

    private String userRole;

    private boolean urgent;

    /**
     * 复杂的业务验证场景：
     * 只有当用户是管理员且任务紧急时，才允许设置过去的时间，否则必须是未来或当前时间
     */
    @SpelFutureOrPresent(
            condition = "#this.userRole != 'admin' || #this.urgent != true",
            message = "只有管理员在紧急情况下才能设置过去的时间"
    )
    private LocalDateTime taskScheduleTime;

    /**
     * 另一个复杂场景：
     * 根据不同条件验证不同的时间要求
     */
    @SpelFuture(
            condition = "#this.userRole != 'admin'",
            message = "普通用户只能设置未来时间"
    )
    @SpelPastOrPresent(
            condition = "#this.userRole == 'admin'",
            message = "管理员可以设置任意时间"
    )
    private LocalDateTime flexibleScheduleTime;

}
