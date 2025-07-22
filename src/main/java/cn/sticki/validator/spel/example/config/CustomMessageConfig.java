package cn.sticki.validator.spel.example.config;

import cn.sticki.spel.validator.core.message.ResourceBundleMessageResolver;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义消息配置
 *
 * @author 阿杆
 * @since 2025/7/22
 */
@Configuration
public class CustomMessageConfig {

    static {
        ResourceBundleMessageResolver.addBasenames("ValidationMessages");
    }

}
