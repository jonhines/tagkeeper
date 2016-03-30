package com.tagkeeper.services;

import com.tagkeeper.entities.Course;
import com.tagkeeper.entities.Player;
import com.tagkeeper.repositories.CourseRepository;
import com.tagkeeper.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * Created by jon on 2/28/16.
 */
@Service
public class CourseService
{
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses()
    {
        List<Course> courses = courseRepository.findAll();

        return courses;
    }

    public List<Course> getCoursesWithinLocationPoint(Point point)
    {
        if (point == null)
        {
            throw new IllegalArgumentException("geolocation point cannot be null");
        }

        Distance maxDistance = new Distance(5, Metrics.MILES);
        List<Course> courses = courseRepository.findByLocationNear(point, maxDistance);
        return courses;
    }
}
