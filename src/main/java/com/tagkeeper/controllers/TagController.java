package com.tagkeeper.controllers;

import com.tagkeeper.entities.Tag;
import com.tagkeeper.exceptions.ResourceNotFoundException;
import com.tagkeeper.repositories.PlayerRepository;
import com.tagkeeper.repositories.TagRepository;
import com.tagkeeper.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by jon on 2/25/16.
 */
@RestController
@RequestMapping("/tags")
public class TagController
{
    @Autowired
    TagService tagService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Tag> getAllTags()
    {
        List<Tag> tags = tagService.getAllTags();
        return tags;

    }

    @RequestMapping(value = "/{tag_id}", method = RequestMethod.GET)
    public Tag getTag(@PathVariable("tag_id") Integer tagId)
    {
        Tag tag = tagService.getTag(tagId);
        if (tag == null)
        {
            throw new ResourceNotFoundException("Could not find tag that matches ID: " + tagId);
        }
        return tag;

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Tag createTag(Tag tagToSave)
    {
        Tag tag = tagService.createTag(tagToSave);
        return tag;
    }


    @RequestMapping(value = "/{tag_id}", method = RequestMethod.PUT)
    public Tag updateTag(@PathVariable("tag_id") Integer tagId, @RequestBody Tag tagToSave)
    {
        Tag tag = tagService.updateTag(tagId, tagToSave);
        return tag;
    }

}
