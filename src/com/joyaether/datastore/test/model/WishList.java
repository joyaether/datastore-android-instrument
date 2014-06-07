package com.joyaether.datastore.test.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.SerializationTypeAdapterFactory;
import com.joyaether.datastore.serialization.ModelTypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@SuppressWarnings("rawtypes")
@DatabaseTable(tableName = "wishlist")
@SerializationTypeAdapterFactory(ModelTypeAdapterFactory.class)
public class WishList extends Model implements Identity {
	
	public static final String ID_FIELD_NAME 	= "wish_list_id";
	public static final String NAME_FIELD_NAME	= "name";
	public static final String COUNTER_FIELD_NAME = "counter";
	
	@DatabaseField(
			columnName = ID_FIELD_NAME,
			canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			indexName = "wish_list_idx")
    @SerializedName(ID_FIELD_NAME)
	@Expose
    private long wishListId;
    
    @DatabaseField(
    		columnName = NAME_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(NAME_FIELD_NAME)
    @Expose
    private String name;
    
    @DatabaseField(
    		columnName = COUNTER_FIELD_NAME,
    		canBeNull = true,
    		defaultValue = "0")
    @SerializedName(COUNTER_FIELD_NAME)
    @Expose
    private int counter;
    
    @ForeignCollectionField(eager = false)
    @SerializedName("items")
    @Expose
    private ForeignCollection <WishItem> items;
    
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

    public void setWishListId(int id) {
        this.wishListId = id;
    }

    public long getWishListId() {
        return wishListId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setCounter(int counter) {
    	this.counter = counter;
    }
    
    public int getCounter() {
    	return counter;
    }
    
    public void setItems(ForeignCollection <WishItem> items) {
        this.items = items;
    }

    public ForeignCollection getItems() {
    	return items;
    }
    
    public List<WishItem> getItemsList() {
        ArrayList<WishItem> itemList = new ArrayList<WishItem>();
        for (WishItem item : items) {
            itemList.add(item);
        }
        return itemList;
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
    
    public static String identity() {
    	return "wishListId";
    }

	@Override
	public Long getIdentity() {
		return Long.valueOf(getWishListId());
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
}
