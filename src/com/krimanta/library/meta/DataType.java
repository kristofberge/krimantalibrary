package com.krimanta.library.meta; 

public class DataType {
	
	public static final DataType LANGUAGES = new DataType("languages", "lang_name", "lang_id");
	public static final DataType WRITERS = new DataType("writers", "writ_name, writ_dateofbirth, writ_dateofdeath, writ_alive", "writ_id");
	
	String tableName;
	String columnsNoId;
	String idColumn;
	
	public DataType(String tableName, String columnsNoId, String idColumn) {
		super();
		this.tableName = tableName;
		this.columnsNoId = columnsNoId;
		this.idColumn = idColumn;
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
}
