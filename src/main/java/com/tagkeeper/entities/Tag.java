package com.tagkeeper.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by jon on 2/25/16.
 */
@Document(collection = "tags")
public class Tag {

    @Id
    private int tagNumber;
    private Date dateAcquired;

    @JsonProperty
    private String playerId;

    @Transient
    private Player player;

    public Tag()
    {

    }

    public Tag(int tagNumber, Date dateAcquired, String playerId)
    {
        this.tagNumber =tagNumber;
        this.dateAcquired = dateAcquired == null ? new Date() : dateAcquired;
        this.playerId = playerId;
    }

    @Id
    public int getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(int tagNumber) {
        this.tagNumber = tagNumber;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    @JsonIgnore
    public String getPlayerId()
    {
        return playerId;
    }

    public void setPlayerId(String playerId)
    {
        this.playerId = playerId;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
}
