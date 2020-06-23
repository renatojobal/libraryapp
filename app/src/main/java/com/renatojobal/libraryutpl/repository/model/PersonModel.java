package com.renatojobal.libraryutpl.repository.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Person model
 */
@Entity
public class PersonModel {


    @PrimaryKey
    private int id;

    private String identification;

    private String firstName;

    /**
     * Full params constructor
     * @param id
     * @param identification
     * @param firstName
     */
    public PersonModel(int id, String identification, String firstName) {
        this.id = id;
        this.identification = identification;
        this.firstName = firstName;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
