package com.soft1851.course.center.service;

import com.soft1851.course.center.entity.Course;
import com.soft1851.course.center.vo.CourseVo;

import java.util.List;
import java.util.Map;

/**
 * (TCourse)表服务接口
 *
 * @author makejava
 * @since 2020-09-16 09:51:42
 */
public interface CourseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CourseVo queryById(String id);


    List<Course> findAll();


}