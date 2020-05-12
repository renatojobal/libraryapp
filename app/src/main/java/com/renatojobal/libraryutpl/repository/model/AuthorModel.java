package com.renatojobal.libraryutpl.repository.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AuthorModel {
    /**
     * Author model
     */

    @PrimaryKey
    private int id;

    private String name;

    private String pseudonym;

    private String nationality;

    private int state;

    public AuthorModel(int id, String name, String pseudonym, String nationality, int state) {
        /**
         * Full params constructor
         */
        this.id = id;
        this.name = name;
        this.pseudonym = pseudonym;
        this.nationality = nationality;
        this.state = state;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
