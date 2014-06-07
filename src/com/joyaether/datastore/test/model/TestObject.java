package com.joyaether.datastore.test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@SuppressWarnings("rawtypes")

@DatabaseTable(tableName = "test_objects")
public class TestObject extends Model implements Identity {
	
	public static final String ID_FIELD_NAME 			= "id";
	public static final String NAME_FIELD_NAME 			= "name";
	public static final String DESCRIPTION_FIELD_NAME	= "description";
	public static final String BYTE_FIELD_NAME = "byte_field";
	public static final String SHORT_FIELD_NAME = "short_field";
	public static final String INT_FIELD_NAME = "int_field";
	public static final String LONG_FIELD_NAME = "long_field";
	public static final String FLOAT_FIELD_NAME = "float_field";
	public static final String DOUBLE_FIELD_NAME = "double_field";
	public static final String BOOLEAN_FIELD_NAME = "boolean_field";
	public static final String CHAR_FIELD_NAME = "char_field";
	
    @DatabaseField(
    		columnName = ID_FIELD_NAME,
    		canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			indexName = "test_object_idx")
    @SerializedName(ID_FIELD_NAME)
    @Expose
    private long itemId;
    
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
    		columnName = BYTE_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(BYTE_FIELD_NAME)
    @Expose
    private byte byteField;    

    @DatabaseField(
    		columnName = SHORT_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(SHORT_FIELD_NAME)
    @Expose
    private short shortField;
    
    @DatabaseField(
    		columnName = INT_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(INT_FIELD_NAME)
    @Expose
    private int intField;
    
    @DatabaseField(
    		columnName = LONG_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(LONG_FIELD_NAME)
    @Expose
    private long longField;
    
    @DatabaseField(
    		columnName = FLOAT_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(FLOAT_FIELD_NAME)
    @Expose
    private float floatField;
    
    @DatabaseField(
    		columnName = DOUBLE_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(DOUBLE_FIELD_NAME)
    @Expose
    private double doubleField;
    
    @DatabaseField(
    		columnName = BOOLEAN_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(BOOLEAN_FIELD_NAME)
    @Expose
    private boolean booleanField;
    
    @DatabaseField(
    		columnName = CHAR_FIELD_NAME,
    		canBeNull = true)
    @SerializedName(CHAR_FIELD_NAME)
    @Expose
    private char charField;
    
    //Identity methods
    
	@Override
	public Long getIdentity() {
		return Long.valueOf(getItemId());
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
    
	//Getters and setters
	
    public void setItemId(int id) {
        this.itemId = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

	public byte getByteField() {
		return byteField;
	}

	public void setByteField(byte byteField) {
		this.byteField = byteField;
	}
	
	public short getShortField() {
		return shortField;
	}

	public void setShortField(short shortField) {
		this.shortField = shortField;
	}
	
	public int getIntField() {
		return intField;
	}

	public void setIntField(int intField) {
		this.intField = intField;
	}

	public long getLongField() {
		return longField;
	}

	public void setLongField(long longField) {
		this.longField = longField;
	}

	public float getFloatField() {
		return floatField;
	}

	public void setFloatField(float floatField) {
		this.floatField = floatField;
	}

	public double getDoubleField() {
		return doubleField;
	}

	public void setDoubleField(double doubleField) {
		this.doubleField = doubleField;
	}

	public boolean getBooleanField() {
		return booleanField;
	}

	public void setBooleanField(boolean booleanField) {
		this.booleanField = booleanField;
	}

	public char getCharField() {
		return charField;
	}

	public void setCharField(char charField) {
		this.charField = charField;
	}

}
