package com.soft1851.course.center.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author zeng
 * @Date 2020/9/16 10:28
 * @Description
 * @Version 1.0
 */
@SpringBootTest
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    @Test
    void queryById() {
        System.out.println(courseMapper.queryById("001"));
    }
}