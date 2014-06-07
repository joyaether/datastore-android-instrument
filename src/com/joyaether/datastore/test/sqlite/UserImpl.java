package com.joyaether.datastore.test.sqlite;

import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.security.User;

@DatabaseTable(tableName = "users")
public class UserImpl extends User {

}
