package com.soft1851.course.center.mapper;

import com.soft1851.course.center.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * (TCourse)表数据库访问层
 *
 * @author cczeng
 * @since 2020-09-16 09:51:42
 */
@Mapper
public interface CourseMapper extends tk.mybatis.mapper.common.Mapper<Course> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("SELECT * FROM t_course WHERE id = #{id}")
    Course queryById(@Param("id") String id);

    @Select("SELECT * FROM t_course c LEFT JOIN t_user u ON c.user_id = u.id")
    List<Map<String, Object>> queryAll();


}