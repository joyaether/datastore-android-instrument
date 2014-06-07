/**
 * Copyright (C) 2012 Joy Aether Ltd.
 */
package com.joyaether.datastore.test.model;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "attributes")
public class Attribute extends Model<Attribute, Long> implements Identity<Long> {

	public final static String ID_FIELD_NAME 									= "attribute_id";
	public final static String NAME_FIELD_NAME 								= "name";
	public final static String DISPLAY_NAME_FIELD_NAME				= "display_name";
	public final static String DATA_TYPE_FIELD_NAME 					= "data_type";
	public final static String U_DEFAULT_VALUE_FIELD_NAME 		= "u_default_value";
	public final static String I_DEFAULT_VALUE_FIELD_NAME 		= "i_default_value";
	public final static String FP_DEFAULT_VALUE_FIELD_NAME 		= "fp_default_value";
	public final static String BLOB_DEFAULT_VALUE_FIELD_NAME	= "blob_default_value";
	public final static String IS_SEARCHABLE_FIELD_NAME 			= "is_searchable";
	public final static String LANGUAGE_SENSITIVE_FIELD_NAME 	= "language_sensitive";
	
	// For acquiring lock on the database table
	public static enum DataType {
		STRING,
		INTEGER,
		FLOAT,
		BLOB,
		TEXT;
	};

	@DatabaseField(
			allowGeneratedIdInsert = true,
			columnName = ID_FIELD_NAME, 
			canBeNull = false, 
			generatedId = true,
			indexName = "attribute_idx")
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private long attributeId;

	@DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = false)
	@SerializedName(NAME_FIELD_NAME)
	@Expose
	private String name;
	
	@DatabaseField(columnName = DISPLAY_NAME_FIELD_NAME, canBeNull = true)
	@SerializedName(DISPLAY_NAME_FIELD_NAME)
	@Expose
	private String displayName;

	@DatabaseField(columnName = DATA_TYPE_FIELD_NAME, canBeNull = false)
	@SerializedName(DATA_TYPE_FIELD_NAME)
	@Expose
	private int dataType;

	@DatabaseField(columnName = U_DEFAULT_VALUE_FIELD_NAME, canBeNull = true)
	@SerializedName(U_DEFAULT_VALUE_FIELD_NAME)
	@Expose
	private String uDefaultValue;

	@DatabaseField(columnName = I_DEFAULT_VALUE_FIELD_NAME, canBeNull = true)
	@SerializedName(I_DEFAULT_VALUE_FIELD_NAME)
	@Expose
	private int iDefaultValue;

	@DatabaseField(columnName = FP_DEFAULT_VALUE_FIELD_NAME, canBeNull = true)
	@SerializedName(FP_DEFAULT_VALUE_FIELD_NAME)
	@Expose
	private float fpDefaultValue;
	
	@DatabaseField(columnName = BLOB_DEFAULT_VALUE_FIELD_NAME, canBeNull = true)
	@SerializedName(BLOB_DEFAULT_VALUE_FIELD_NAME)
	@Expose
	private String blobDefaultValue;

	@DatabaseField(columnName = IS_SEARCHABLE_FIELD_NAME, canBeNull = false)
	@SerializedName(IS_SEARCHABLE_FIELD_NAME)
	@Expose
	private boolean isSearchable;

	@DatabaseField(columnName = LANGUAGE_SENSITIVE_FIELD_NAME, canBeNull = false)
	@SerializedName(LANGUAGE_SENSITIVE_FIELD_NAME)
	@Expose
	private boolean languageSensitive;

	@DatabaseField(
			columnName = CREATED_DATE_FIELD_NAME, 
			canBeNull = true,
			dataType = com.j256.ormlite.field.DataType.DATE_STRING,
			format = "yyyy-MM-dd HH:mm:ss")
  @SerializedName(CREATED_DATE_FIELD_NAME)
  @Expose
  private Date createdDate;
	
	@DatabaseField(
			columnName = LAST_MODIFIED_DATE_FIELD_NAME, 
			canBeNull = false,
			dataType = com.j256.ormlite.field.DataType.DATE_STRING,
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFIED_DATE_FIELD_NAME)
	@Expose
	private Date lastModifiedDate;

	public Attribute() {}
	
	public Attribute(
			long attributeId,
			String name, 
			String displayName,
			int dataType, 
			String uDefaultValue, 
			int iDefaultValue, 
			float fpDefaultValue, 
			String blobDefaultValue,
			boolean isSearchable, 
			boolean languageSensitive, 
			Date createdDate,
			Date lastModifiedDate) {
		
		this.attributeId = attributeId;
		this.name = name;
		this.displayName = displayName;
		this.dataType = dataType;
		this.uDefaultValue = uDefaultValue;
		this.iDefaultValue = iDefaultValue;
		this.fpDefaultValue = fpDefaultValue;
		this.blobDefaultValue = blobDefaultValue;
		this.isSearchable = isSearchable;
		this.languageSensitive = languageSensitive;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	@Override
	public int hashCode() {
		return (int) attributeId;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || other.getClass() != getClass()) {
			return false;
		}
		return this.attributeId == ((Attribute) other).getAttributeId();
	}

	@Override
	public Long getIdentity() {
		return Long.valueOf(getAttributeId());
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}

	public long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public DataType getDataType() {
		return DataType.values()[dataType];
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType.ordinal();
	}

	public String getStringTypeDefaultValue() {
		return uDefaultValue;
	}

	public void setStringTypeDefaultValue(String uDefaultValue) {
		this.uDefaultValue = uDefaultValue;
	}

	public int getIntegerTypeDefaultValue() {
		return iDefaultValue;
	}

	public void setIntegerTypeDefaultValue(int iDefaultValue) {
		this.iDefaultValue = iDefaultValue;
	}

	public float getFloatingPointTypeDefaultValue() {
		return fpDefaultValue;
	}

	public void setFloatingPointTypeDefaultValue(float fpDefaultValue) {
		this.fpDefaultValue = fpDefaultValue;
	}
	
	public String getBlobDefaultValue() {
		return blobDefaultValue;
	}
	
	public void setBlobDefaultValue(String blobDefaultValue) {
		this.blobDefaultValue = blobDefaultValue;
	}

	public boolean isSearchable() {
		return isSearchable;
	}

	public void setSearchable(boolean isSearchable) {
		this.isSearchable = isSearchable;
	}

	public boolean isLanguageSensitive() {
		return languageSensitive;
	}

	public void setLanguageSensitivity(boolean languageSensitive) {
		this.languageSensitive = languageSensitive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	
}
