package com.xiaofu.subject.domain;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 刷题 controller
 *
 * @author xiaofu
 * @date 2024/1/10 22:10
 */

@RestController
public class SubjectjDomainTest {

    @PostMapping("/test")
    public String test() {

        return "test... hello world !!";

    }

}
