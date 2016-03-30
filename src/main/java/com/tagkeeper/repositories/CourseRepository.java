package com.tagkeeper.repositories;

import com.tagkeeper.entities.Course;
import com.tagkeeper.entities.Tag;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jon on 2/25/16.
 */
@Repository
public interface CourseRepository extends MongoRepository<Course, String>
{
    List<Course> findByLocationWithin(Point point);

    List<Course> findByLocationNear(Point p, Distance d);

    Course findByName(String name);
}
