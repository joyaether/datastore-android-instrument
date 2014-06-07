package com.joyaether.datastore.test.model;

import java.util.Date;

import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@SuppressWarnings("rawtypes")

@DatabaseTable(tableName = "wishitem")
public class WishItem extends Model implements Identity {
	
	public static final String ID_FIELD_NAME 			= "id";
	public static final String NAME_FIELD_NAME 			= "name";
	public static final String DESCRIPTION_FIELD_NAME	= "description";
	public static final String WISH_LIST_FIELD_NAME		= "wish_list";
	
    @DatabaseField(
    		columnName = ID_FIELD_NAME,
    		canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			indexName = "wish_item_idx")
    @SerializedName(ID_FIELD_NAME)
    @Expose
    private long wishItemId;
    
    @DatabaseField(
    		columnName = NAME_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(NAME_FIELD_NAME)
    @Expose
    private String name;

    @DatabaseField(
    		columnName = DESCRIPTION_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(DESCRIPTION_FIELD_NAME)
    @Expose
    private String description;
    
    @DatabaseField(
    		columnName = WISH_LIST_FIELD_NAME + "_id",
    		foreign = true,
    		canBeNull = true,
    		indexName = "wish_item_wish_list_idx",
    		// if the wishlist was deleted, the wish_list_id of wishitem will be set to NULL
    		columnDefinition = "BIGINT REFERENCES wishlist(wish_list_id) ON DELETE SET NULL ON UPDATE NO ACTION",
    		foreignAutoCreate = true,
    		foreignAutoRefresh = false)
    @Expose
    private WishList wishList;
    
    @DatabaseField(
    		columnName = CREATED_DATE_FIELD_NAME, 
    		canBeNull = true,
    		dataType = DataType.DATE_STRING,
    		format = "yyyy-MM-dd HH:mm:ss")
    @SerializedName(CREATED_DATE_FIELD_NAME)
    @Expose
    private Date createdDate;

    @DatabaseField(
    		columnName = LAST_MODIFIED_DATE_FIELD_NAME, 
    		canBeNull = false,
    		dataType = DataType.DATE_STRING,
    		format = "yyyy-MM-dd HH:mm:ss")
    @SerializedName(LAST_MODIFIED_DATE_FIELD_NAME)
    @Expose
    private Date lastModifiedDate;

    public void setWishItemId(int id) {
        this.wishItemId = id;
    }

    public long getWishItemId() {
        return wishItemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWishList(WishList list) {
        this.wishList = list;
    }

    public WishList getList() {
        return wishList;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public void setCreatedDate(Date theDate) {
    	this.createdDate = theDate;
    }
    
    public Date getCreatedDate() {
    	return createdDate;
    }
    
    public void setLastModifiedDate(Date theDate) {
    	this.lastModifiedDate = theDate;
    }
    
    public Date getLastModifiedDate() {
    	return lastModifiedDate;
    }

	@Override
	public Long getIdentity() {
		return Long.valueOf(getWishItemId());
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
}
