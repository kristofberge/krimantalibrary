package com.krimanta.library.meta;

import com.krimanta.library.dto.*; 

public class DataType {
	
	public static final DataType LANGUAGES = new DataType("languages", "lang_name", "lang_id", Language.class);
	
	String tableName;
	String columnsNoId;
	String idColumn;
	Class dtoClass;
	
	public DataType(String tableName, String columnsNoId, String idColumn,
			Class dtoClass) {
		super();
		this.tableName = tableName;
		this.columnsNoId = columnsNoId;
		this.idColumn = idColumn;
		this.dtoClass = dtoClass;
	}
	public String getTableName() {
		return tableName;
	}
	public String getColumnsNoId() {
		return columnsNoId;
	}
	public String getIdColumn() {
		return idColumn;
	}
	public String getAllColumns() {
		return idColumn + ", " + columnsNoId;
	}
	public Class getDtoClass() {
		return dtoClass;
	}
}
