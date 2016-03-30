package com.tagkeeper.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jon on 2/25/16.
 */
@Document(collection = "players")
public class Player {

    private String id;
    private String firstName;
    private String lastName;
    private String throwingHand;
    private String favoriteDisc;
    private int careerAces;

    public Player()
    {

    }

    public Player(String firstName, String lastName, String throwingHand, String favoriteDisc, int careerAces)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.throwingHand = throwingHand;
        this.favoriteDisc = favoriteDisc;
        this.careerAces = careerAces;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getThrowingHand() {
        return throwingHand;
    }

    public void setThrowingHand(String throwingHand) {
        this.throwingHand = throwingHand;
    }

    public String getFavoriteDisc() {
        return favoriteDisc;
    }

    public void setFavoriteDisc(String favoriteDisc) {
        this.favoriteDisc = favoriteDisc;
    }

    public int getCareerAces() {
        return careerAces;
    }

    public void setCareerAces(int careerAces) {
        this.careerAces = careerAces;
    }
}