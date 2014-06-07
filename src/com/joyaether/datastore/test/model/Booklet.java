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

@DatabaseTable(tableName = "booklets")
public class Booklet extends Model implements Identity {

	public static final String ID_FIELD_NAME 			= "booklet_id";
	public static final String NAME_FIELD_NAME 			= "booklet_name_en_us";
	
    @DatabaseField(
    		columnName = ID_FIELD_NAME,
    		canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			indexName = "booklet_idx")
    @SerializedName(ID_FIELD_NAME)
    @Expose
    private long bookletId;
    
    @DatabaseField(
    		columnName = NAME_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(NAME_FIELD_NAME)
    @Expose
    private String bookletNameEnUs;
    
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
    
	@Override
	public Object getIdentity() {
		return Long.valueOf(getBookletId());
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
	
	public Long getBookletId() {
		return Long.valueOf(bookletId);
	}

	public void setBookletId(long theBookletId) {
		this.bookletId = theBookletId;
	}
	
	public String getBookletNameEnUs() {
		return bookletNameEnUs;
	}
	
	public void setBookletNameEnUs(String theBookletNameEnUs) {
		this.bookletNameEnUs = theBookletNameEnUs;
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
}
