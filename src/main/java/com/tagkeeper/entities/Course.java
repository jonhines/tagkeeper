package com.tagkeeper.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jon on 2/28/16.
 */
@Document(collection = "courses")
public class Course
{
    @Id
    private String id;
    private String name;
    private Point location;

    public Course(String name, Point location)
    {
        this.name = name;
        this.location = location;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Point getLocation()
    {
        return location;
    }

    public void setLocation(Point location)
    {
        this.location = location;
    }
}
