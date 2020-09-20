package com.soft1851.course.center.service.impl;

import com.soft1851.course.center.entity.Course;
import com.soft1851.course.center.entity.User;
import com.soft1851.course.center.mapper.CourseMapper;
import com.soft1851.course.center.service.CourseService;
import com.soft1851.course.center.vo.CourseVo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (TCourse)表服务实现类
 *
 * @author czeng
 * @since 2020-09-16 09:51:42
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Resource
    private RestTemplate restTemplate;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CourseVo queryById(String id) {

        Course course = courseMapper.queryById(id);
        String userId = course.getUserId();
        User user = restTemplate.getForObject("http://120.25.149.156:8003/user/selectById/{id}", User.class, userId);
        assert user != null;
        return CourseVo.builder()
                .course(course)
                .uId(user.getId())
                .userName(user.getName())
                .avatar(user.getAvatar())
                .build();
    }


    @Override
    public List<Course> findAll() {
        return courseMapper.selectAll();
    }

}