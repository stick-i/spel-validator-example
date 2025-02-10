package cn.sticki.validator.spel.example.controller;

import cn.sticki.spel.validator.jakarta.SpelValid;
import cn.sticki.validator.spel.example.vo.GroupTestParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分组校验测试
 *
 * @author 阿杆
 * @since 2025/2/10
 */
@Validated
@Slf4j
@RestController
@RequestMapping("/test/group")
public class GroupTestController {

    @PostMapping("/addUser")
    public void addUser(@RequestBody @Validated @SpelValid(spelGroups = GroupTestParamVo.Group.ADD) GroupTestParamVo add) {
        log.info("addUser: {}", add);
    }

    @PostMapping("/updateUser")
    public void updateUser(@RequestBody @Validated @SpelValid(spelGroups = GroupTestParamVo.Group.UPDATE) GroupTestParamVo update) {
        log.info("updateUser: {}", update);
    }

}
