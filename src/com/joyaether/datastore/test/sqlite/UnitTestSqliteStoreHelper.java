/**
 * Copyright (C) 2013 Joy Aether Ltd.
 */
package com.joyaether.datastore.test.sqlite;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Schema;
import com.joyaether.datastore.security.Role;
import com.joyaether.datastore.sqlite.SqliteStoreHelper;
import com.joyaether.datastore.test.model.Attribute;
import com.joyaether.datastore.test.model.EsquelUser;
import com.joyaether.datastore.test.model.Webcast;

public class UnitTestSqliteStoreHelper extends SqliteStoreHelper {
	
	private final String TAG = UnitTestSqliteStoreHelper.class.getSimpleName();
	
	/** Data schemas */
	public static final String SCHEMA_USER = Schema.getAttributes(UserImpl.class).getTableName();
	public static final String SCHEMA_ROLE = Schema.getAttributes(Role.class).getTableName();
	public static final String SCHEMA_ATTRIBUTE = Schema.getAttributes(Attribute.class).getTableName();
	public static final String SCHEMA_ESQUEL_USER = Schema.getAttributes(EsquelUser.class).getTableName();
	public static final String SCHEMA_WEBCAST = Schema.getAttributes(Webcast.class).getTableName();
	
	private final Map<String, Class<? extends Model<?, ?>>> SCHEMA = 
		new ConcurrentHashMap<String, Class<? extends Model<?, ?>>>() {
		
		private static final long serialVersionUID = 9084349657357243355L;

		{
			put(SCHEMA_USER, UserImpl.class);
			put(SCHEMA_ROLE, Role.class);
			put(SCHEMA_ATTRIBUTE, Attribute.class);
			put(SCHEMA_WEBCAST, Webcast.class);
		}
		
	};

	/**
	 * Creates a new instance of {@link UnitTestSqliteStoreHelper}
	 * 
	 * @param context The context that this helper runs in
	 */
	public UnitTestSqliteStoreHelper(Context context) {
		super(context);
	}

	@Override
	public String getDatabaseName() {
		return "sqlitestore.db";
	}

	@Override
	public int getVersion() {
		return 1;
	}

	@Override
	public Class<? extends Model<?, ?>> getSchema(String name) {
		return SCHEMA.get(name);
	}

	@Override
	public void onCreate(ConnectionSource connectionSource) {
		try {
			Collection<Class<? extends Model<?, ?>>> classes = SCHEMA.values();
			for (Class<?> clazz : classes) {
				TableUtils.createTable(connectionSource, clazz);
			}
		} catch (Exception ex) {
			Log.e(TAG, "Failed to create tables");
		}
	}

	@Override
	public void onUpgrade(ConnectionSource connectionSource, int oldVersion, int newVersion) {
		
	}

}
