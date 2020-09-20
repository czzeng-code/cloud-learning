package com.soft1851.course.center.vo;

import com.soft1851.course.center.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zeng
 * @Date 2020/9/16 9:55
 * @Description
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseVo {

    private Course course;

    private String uId;

    private String avatar;

    private String userName;



}
