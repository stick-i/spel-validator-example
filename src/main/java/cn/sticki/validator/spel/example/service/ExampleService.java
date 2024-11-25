package cn.sticki.validator.spel.example.service;

import cn.sticki.validator.spel.example.po.User;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 示例服务
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/11/25
 */
@Slf4j
@Service
public class ExampleService {

	@PostConstruct
	public void init() {
		log.info("ExampleService init");
	}

	/**
	 * 示例方法
	 */
	public User getUser(int id) {
		User user = new User();
		user.setId(id);
		user.setName("阿杆");
		return user;
	}

}
