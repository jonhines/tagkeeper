package com.tagkeeper.services;

import com.tagkeeper.entities.Player;
import com.tagkeeper.entities.Tag;
import com.tagkeeper.exceptions.ResourceNotFoundException;
import com.tagkeeper.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by jon on 2/28/16.
 */
@Service
public class TagService
{
    @Autowired
    TagRepository tagRepository;

    @Autowired
    PlayerService playerService;

    public List<Tag> getAllTags()
    {
        List<Tag> tags = tagRepository.findAll();
        tags.stream().filter(t -> t.getPlayerId() != null).forEach(t -> t.setPlayer(playerService.getPlayer(t.getPlayerId())));

        return tags;
    }

    public Tag getTag(Integer tagId)
    {
        if (tagId == null)
        {
            throw new IllegalArgumentException("tagId cannot be null");
        }

        Tag tag = tagRepository.findOne(tagId);
        if (tag != null && isNotBlank(tag.getPlayerId()))
        {
            Player player = playerService.getPlayer(tag.getPlayerId());
            tag.setPlayer(player);
        }

        return tag;
    }

    public Tag createTag(Tag tag)
    {
        if (tag == null)
        {
            throw new IllegalArgumentException("tag cannot be null");
        }
        Tag savedTag = tagRepository.save(tag);

        Tag fetchedTag = getTag(savedTag.getTagNumber());

        return fetchedTag;
    }

    public Tag updateTag(Integer tagId, Tag tag)
    {
        Tag tagToUpdate = getTag(tagId);
        tagToUpdate.setDateAcquired(new Date());

        validateAndVacatePlayer(tag.getPlayerId());

        tagToUpdate.setPlayerId(tag.getPlayerId());
        tagToUpdate = tagRepository.save(tagToUpdate);

        Tag fetchedTag = getTag(tagToUpdate.getTagNumber());
        return fetchedTag;
    }


    public Tag swapTags(Integer tagId, Tag tag)
    {
        Tag tagToUpdate = getTag(tagId);
        tagToUpdate.setDateAcquired(new Date());

        validateAndVacatePlayer(tag.getPlayerId());

        tagToUpdate.setPlayerId(tag.getPlayerId());
        tagToUpdate = tagRepository.save(tagToUpdate);

        Tag fetchedTag = getTag(tagToUpdate.getTagNumber());
        return fetchedTag;
    }

    /**
     * Ensure that if a playerId is given, that it belongs to an existing {@link Player}.
     * If an existing Player exists, vacate it from their current tag.
     * @param playerId
     */
    private void validateAndVacatePlayer(String playerId)
    {
        if (isNotBlank(playerId))
        {
            Player player = playerService.getPlayer(playerId);
            if (player == null)
            {
                throw new ResourceNotFoundException("Player with ID " + playerId + ", does not exist.");
            }
            vacatePlayerFromExistingTag(playerId);
        }
    }

    protected void vacatePlayerFromExistingTag(String playerId)
    {
        Tag playerTag = tagRepository.findByPlayerId(playerId);
        if(playerTag != null)
        {
            playerTag.setPlayerId(null);
            tagRepository.save(playerTag);
        }
    }

}
