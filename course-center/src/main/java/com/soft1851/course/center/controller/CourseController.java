package com.soft1851.course.center.controller;

import com.soft1851.course.center.common.ResponseResult;
import com.soft1851.course.center.entity.Course;
import com.soft1851.course.center.entity.User;
import com.soft1851.course.center.service.CourseService;
import com.soft1851.course.center.service.impl.CourseServiceImpl;
import com.soft1851.course.center.vo.CourseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zeng
 * @since 2020-09-16 09:51:43
 */
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {
    //构造器注入
    private final CourseService courseService;

    private final RestTemplate restTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne/{id}")
    public CourseVo selectOne(@PathVariable("id") String id) {
        return this.courseService.queryById(id);
    }

    @GetMapping("/all")
    public ResponseResult getAll() {
        List<Course> courses = courseService.findAll();
        List<CourseVo> courseVoList = new ArrayList<>();
        courses.forEach(course -> {
            String userId = course.getUserId();
            User user = restTemplate.getForObject("http://120.25.149.156:8003/user/selectById/{id}", User.class, userId);
            assert user != null;
            CourseVo courseVo = CourseVo.builder()
                    .course(course)
                    .uId(user.getId())
                    .userName(user.getName())
                    .avatar(user.getAvatar())
                    .build();
            courseVoList.add(courseVo);
        });
        return new ResponseResult(200, "请求成功", courseVoList);
    }

    @GetMapping("/getPyApi")
    public ResponseResult getPythonApi() {
        Object hello = restTemplate.getForObject("http://127.0.0.1:5001/hello", Object.class);
        return new ResponseResult(200, "请求成功", hello);
    }

}