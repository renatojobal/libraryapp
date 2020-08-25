package com.renatojobal.libraryutpl.repository.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

/**
 * Agent model
 * <p>
 * Probably we don't need to use it on the client side. Only in backend.
 */
@Entity(foreignKeys = {
        @ForeignKey(entity = ShelfModel.class,
                parentColumns = DBConstants.SHELF_ID,
                childColumns = DBConstants.AGENT_ID,
                onDelete = ForeignKey.CASCADE)
})
public class AgentModel {


    @PrimaryKey
    @NonNull
    private Integer id;

    private int requestDelay;

    private int updateSettingsDelay;

    private String productionUrl;

    private String developmentUrl;

    private Integer fkShelf;

    /**
     * Full params constructor
     * @param id
     * @param requestDelay
     * @param updateSettingsDelay
     * @param productionUrl
     * @param developmentUrl
     * @param fkShelf
     */
    public AgentModel(Integer id, int requestDelay, int updateSettingsDelay, String productionUrl, String developmentUrl, Integer fkShelf) {
        this.id = id;
        this.requestDelay = requestDelay;
        this.updateSettingsDelay = updateSettingsDelay;
        this.productionUrl = productionUrl;
        this.developmentUrl = developmentUrl;
        this.fkShelf = fkShelf;
    }

    // Getter and setters
    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public int getRequestDelay() {
        return requestDelay;
    }

    public void setRequestDelay(int requestDelay) {
        this.requestDelay = requestDelay;
    }

    public int getUpdateSettingsDelay() {
        return updateSettingsDelay;
    }

    public void setUpdateSettingsDelay(int updateSettingsDelay) {
        this.updateSettingsDelay = updateSettingsDelay;
    }

    public String getProductionUrl() {
        return productionUrl;
    }

    public void setProductionUrl(String productionUrl) {
        this.productionUrl = productionUrl;
    }

    public String getDevelopmentUrl() {
        return developmentUrl;
    }

    public void setDevelopmentUrl(String developmentUrl) {
        this.developmentUrl = developmentUrl;
    }

    public Integer getFkShelf() {
        return fkShelf;
    }

    public void setFkShelf(Integer fkShelf) {
        this.fkShelf = fkShelf;
    }
}
