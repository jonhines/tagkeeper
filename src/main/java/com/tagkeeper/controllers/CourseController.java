package com.tagkeeper.controllers;

import com.tagkeeper.entities.Course;
import com.tagkeeper.entities.Player;
import com.tagkeeper.services.CourseService;
import com.tagkeeper.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jon on 2/25/16.
 */
@RestController
@RequestMapping("/courses")
public class CourseController
{
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Course> getAllCourses()
    {
        List<Course> courses = courseService.getAllCourses();
        return courses;
    }

    @RequestMapping(value = "/byLocation", method = RequestMethod.GET)
    public List<Course> getAllCoursesWithinPoint(@RequestParam("x") double x, @RequestParam("y") double y)
    {
        Point point = new Point(x, y);
        List<Course> courses = courseService.getCoursesWithinLocationPoint(point);

        return courses;

    }
}
