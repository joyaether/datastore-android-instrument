package com.joyaether.datastore.test.model;

import java.net.URL;
import java.util.Date;
import java.util.Locale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.BlobDatabaseField;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "webcasts")
public class Webcast extends Model<Webcast, Long> implements Identity<Long> {
	
	// For QueryBuilder to be able to find the fields
	public static final String ID_FIELD_NAME 									= "webcast_id";
	public static final String NAME_EN_US_FIELD_NAME					= "name_en_us";
	public static final String NAME_ZH_TW_FIELD_NAME					= "name_zh_tw";
	public static final String NAME_ZH_CN_FIELD_NAME					= "name_zh_cn";
	public static final String URL_EN_US_FIELD_NAME						= "url_en_us";
	public static final String URL_ZH_TW_FIELD_NAME						= "url_zh_tw";
	public static final String URL_ZH_CN_FIELD_NAME						= "url_zh_cn";
	public static final String IMAGE_EN_US_FIELD_NAME					= "image_en_us";
	public static final String IMAGE_ZH_TW_FIELD_NAME					= "image_zh_tw";
	public static final String IMAGE_ZH_CN_FIELD_NAME					= "image_zh_cn";
	public static final String LENGTH_EN_US_FIELD_NAME				= "length_en_us";
	public static final String LENGTH_ZH_TW_FIELD_NAME				= "length_zh_tw";
	public static final String LENGTH_ZH_CN_FIELD_NAME				= "length_zh_cn";
	public static final String UPLOADED_DATE_EN_US_FIELD_NAME	= "uploadeddate_en_us";
	public static final String UPLOADED_DATE_ZH_TW_FIELD_NAME	= "uploadeddate_zh_tw";
	public static final String UPLOADED_DATE_ZH_CN_FIELD_NAME	= "uploadeddate_zh_cn";
	public static final String TYPE_FIELD_NAME								= "type";
	public static final String SEQUENCE_FIELD_NAME						= "sequence";
	
	// The type of the webcast
	public static enum WebcastType {
		INTERVIEW,
		HIGHLIGHT
	};
	
	@DatabaseField(
			allowGeneratedIdInsert = true,
			columnName = ID_FIELD_NAME, 
			canBeNull = false, 
			generatedId = true,
			indexName = "webcast_idx")
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private long webcastId;
	
	@DatabaseField(columnName = NAME_EN_US_FIELD_NAME, canBeNull = true)
	@SerializedName(NAME_EN_US_FIELD_NAME)
	@Expose
	private String name_en_US;
	
	@DatabaseField(columnName = NAME_ZH_TW_FIELD_NAME, canBeNull = true)
	@SerializedName(NAME_ZH_TW_FIELD_NAME)
	@Expose
	private String name_zh_TW;
	
	@DatabaseField(columnName = NAME_ZH_CN_FIELD_NAME, canBeNull = true)
	@SerializedName(NAME_ZH_CN_FIELD_NAME)
	@Expose
	private String name_zh_CN;
	
	@DatabaseField(columnName = URL_EN_US_FIELD_NAME, canBeNull = true)
	@SerializedName(URL_EN_US_FIELD_NAME)
	@Expose
	private String url_en_US;
	
	@DatabaseField(columnName = URL_ZH_TW_FIELD_NAME, canBeNull = true)
	@SerializedName(URL_ZH_TW_FIELD_NAME)
	@Expose
	private String url_zh_TW;
	
	@DatabaseField(columnName = URL_ZH_CN_FIELD_NAME, canBeNull = true)
	@SerializedName(URL_ZH_CN_FIELD_NAME)
	@Expose
	private String url_zh_CN;
	
	@DatabaseField(columnName = IMAGE_EN_US_FIELD_NAME, canBeNull = true)
	@BlobDatabaseField(baseURI = "/resources/webcasts")
	@SerializedName(IMAGE_EN_US_FIELD_NAME)
	@Expose
	private String image_en_US;
	
	@DatabaseField(columnName = IMAGE_ZH_TW_FIELD_NAME, canBeNull = true)
	@BlobDatabaseField(baseURI = "/resources/webcasts")
	@SerializedName(IMAGE_ZH_TW_FIELD_NAME)
	@Expose
	private String image_zh_TW;
	
	@DatabaseField(columnName = IMAGE_ZH_CN_FIELD_NAME, canBeNull = true)
	@BlobDatabaseField(baseURI = "/resources/webcasts")
	@SerializedName(IMAGE_ZH_CN_FIELD_NAME)
	@Expose
	private String image_zh_CN;
	
	@DatabaseField(columnName = LENGTH_EN_US_FIELD_NAME, canBeNull = true)
	@SerializedName(LENGTH_EN_US_FIELD_NAME)
	@Expose
	private String length_en_US;
	
	@DatabaseField(columnName = LENGTH_ZH_TW_FIELD_NAME, canBeNull = true)
	@SerializedName(LENGTH_ZH_TW_FIELD_NAME)
	@Expose
	private String length_zh_TW;
	
	@DatabaseField(columnName = LENGTH_ZH_CN_FIELD_NAME, canBeNull = true)
	@SerializedName(LENGTH_ZH_CN_FIELD_NAME)
	@Expose
	private String length_zh_CN;
	
	@DatabaseField(
			columnName = UPLOADED_DATE_EN_US_FIELD_NAME, 
			canBeNull = true,
			dataType = DataType.DATE_STRING,
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(UPLOADED_DATE_EN_US_FIELD_NAME)
	@Expose
	private Date uploadedDate_en_US;
	
	@DatabaseField(
			columnName = UPLOADED_DATE_ZH_TW_FIELD_NAME, 
			canBeNull = true,
			dataType = DataType.DATE_STRING,
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(UPLOADED_DATE_ZH_TW_FIELD_NAME)
	@Expose
	private Date uploadedDate_zh_TW;
	
	@DatabaseField(
			columnName = UPLOADED_DATE_ZH_CN_FIELD_NAME, 
			canBeNull = true,
			dataType = DataType.DATE_STRING,
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(UPLOADED_DATE_ZH_CN_FIELD_NAME)
	@Expose
	private Date uploadedDate_zh_CN;
	
	@DatabaseField(columnName = TYPE_FIELD_NAME, canBeNull = false)
	@SerializedName(TYPE_FIELD_NAME)
	@Expose
	private int type;
	
	@DatabaseField(columnName = SEQUENCE_FIELD_NAME, canBeNull = true)
	@SerializedName(SEQUENCE_FIELD_NAME)
	@Expose
	private long sequence;
	
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
	
	public Webcast(){
		// all persisted classes must define a no-arg constructor with at least
		// package visibility
	}
	
	public Webcast(
			int webcastId,
			String name_en_US,
			String name_zh_TW,
			String name_zh_CN,
			String url_en_US,
			String url_zh_TW,
			String url_zh_CN,
			String image_en_US,
			String image_zh_TW,
			String image_zh_CN,
			String length_en_US,
			String length_zh_TW,
			String length_zh_CN,
			Date uploadedDate_en_US,
			Date uploadedDate_zh_TW,
			Date uploadedDate_zh_CN,
			int type,
			long sequence,
			Date createdDate,
			Date lastModifiedDate) {
		
		this.webcastId = webcastId;
		this.name_en_US = name_en_US;
		this.name_zh_TW = name_zh_TW;
		this.name_zh_CN = name_zh_CN;
		this.url_en_US = url_en_US;
		this.url_zh_TW = url_zh_TW;
		this.url_zh_CN = url_zh_CN;
		this.image_en_US = image_en_US;
		this.image_zh_TW = image_zh_TW;
		this.image_zh_CN = image_zh_CN;
		this.length_en_US = length_en_US;
		this.length_zh_TW = length_zh_TW;
		this.length_zh_CN = length_zh_CN;
		this.uploadedDate_en_US = uploadedDate_en_US;
		this.uploadedDate_zh_TW = uploadedDate_zh_TW;
		this.uploadedDate_zh_CN = uploadedDate_zh_CN;
		this.type = type;
		this.sequence = sequence;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	@Override
	public int hashCode() {
		return (int) webcastId;
	}
	
	@Override
	public Long getIdentity() {
		return Long.valueOf(getWebcastId());
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
	
	public long getWebcastId() {
		return webcastId;
	}
	
	public void getWebcastId(long webcastId) {
		this.webcastId = webcastId;
	}
	
	public String getName(Locale locale) {
		Object result = getFieldValue("name_" + locale.toString().replace("-", "_"));
		return result == null ? null : (String) result;
	}
	
	public void setName(String value, Locale locale) {
		setFieldValue("name_" + locale.toString().replace("-", "_"), value);
	}
	
	public String getUrl(Locale locale) {
		Object result = getFieldValue("url_" + locale.toString().replace("-", "_"));
		return result == null ? null : (String) result;
	}
	
	public void setUrl(URL url, Locale locale) {
		setFieldValue("url_" + locale.toString().replace("-", "_"), url.toString());
	}
	
	public String getImage(Locale locale) {
		Object result = getFieldValue("image_" + locale.toString().replace("-", "_"));
		return result == null ? null : (String) result;
	}
	
	public void setImage(URL image, Locale locale) {
		setFieldValue("image_" + locale.toString().replace("-", "_"), image.toString());
	}
	
	public String getLength(Locale locale) {
		Object result = getFieldValue("length_" + locale.toString().replace("-", "_"));
		return result == null ? null : (String) result;
	}
	
	public void setLength(String length, Locale locale) {
		setFieldValue("length_" + locale.toString().replace("-", "_"), length);
	}
	
	public WebcastType getType() {
		return type == 0 ? WebcastType.INTERVIEW : WebcastType.HIGHLIGHT;
	}
	
	public Date getUploadedDate(Locale locale) {
		Object result = getFieldValue("uploadedDate_" + locale.toString().replace("-", "_"));
		return result == null ? null : (Date) result;
	}
	
	public void setUploadedDate(Date uploadedDate, Locale locale) {
		setFieldValue("uploadedDate_" + locale.toString().replace("-", "_"), uploadedDate);
	}
	
	public void setType(WebcastType type) {
		this.type = type == WebcastType.INTERVIEW ? 0 : 1;
	}
	
	public long getSequence() {
		return sequence;
	}
	
	public void setSequence(long value) {
		sequence = value;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

}
