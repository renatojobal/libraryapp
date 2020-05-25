package com.renatojobal.libraryutpl.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

import java.io.Serializable;

@Entity(tableName = DBConstants.AUTHOR_TABLE)
public class AuthorModel  implements Serializable {
    /**
     * Author model
     */

    @PrimaryKey
    @ColumnInfo(name = DBConstants.AUTHOR_ID)
    private int authorModelId;

    @ColumnInfo(name = DBConstants.AUTHOR_NAME)
    private String name;

    @ColumnInfo(name = DBConstants.AUTHOR_PSEUDONYM)
    private String pseudonym;

    @ColumnInfo(name = DBConstants.AUTHOR_NATIONALITY)
    private String nationality;

    @SerializedName("state")
    @ColumnInfo(name = DBConstants.AUTHOR_STATE)
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
