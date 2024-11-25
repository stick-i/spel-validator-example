package cn.sticki.validator.spel.example.config;

import cn.sticki.spel.validator.core.parse.SpelValidatorBeanRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * Spel 验证器配置
 * <p>
 * 如果你使用了 spring.main.lazy-initialization=true 配置项，
 * 那么 @EnableSpelValidatorBeanRegistrar 注解将不会生效，
 * 你需要手动注册 SpelValidatorBeanRegistrar，
 * 并且设置 @Lazy(false) 以确保在启动时加载
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/11/25
 */
// @Configuration
public class SpelValidatorConfig {

	@Bean
	@Lazy(false)
	public SpelValidatorBeanRegistrar spelValidatorBeanRegistrar() {
		return new SpelValidatorBeanRegistrar();
	}

}
