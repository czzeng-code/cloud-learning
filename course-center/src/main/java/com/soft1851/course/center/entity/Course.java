package com.soft1851.course.center.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (TCourse)实体类
 *
 * @author makejava
 * @since 2020-09-16 15:45:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_course")
public class Course implements Serializable {
    private static final long serialVersionUID = -45157472313496869L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    private String userId;

    private String courseName;

    private Boolean isEnding;

    private String className;

    private String cover;

}