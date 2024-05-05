package cn.sticki.validator.spel.example;

import cn.sticki.validator.spel.parse.EnableSpelValidatorBeanRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 阿杆
 */
@EnableSpelValidatorBeanRegistrar
@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
