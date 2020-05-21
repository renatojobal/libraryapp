package com.renatojobal.libraryutpl.repository.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class AuthorModel  implements Serializable {
    /**
     * Author model
     */

    @PrimaryKey
    private int authorModelId;

    private String name;

    private String pseudonym;

    private String nationality;

    @SerializedName("state")
    private int authorState;

    public AuthorModel(int authorModelId, String name, String pseudonym, String nationality, int authorState) {
        /**
         * Full params constructor
         */
        this.authorModelId = authorModelId;
        this.name = name;
        this.pseudonym = pseudonym;
        this.nationality = nationality;
        this.authorState = authorState;
    }

    // Getter and setters
    public int getAuthorModelId() {
        return authorModelId;
    }

    public void setAuthorModelId(int authorModelId) {
        this.authorModelId = authorModelId;
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

    public int getAuthorState() {
        return authorState;
    }

    public void setAuthorState(int authorState) {
        this.authorState = authorState;
    }
}
