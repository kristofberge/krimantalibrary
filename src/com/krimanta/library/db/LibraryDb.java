package com.krimanta.library.db;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.krimanta.library.dto.Language;
import com.krimanta.library.dto.MyDto;
import com.krimanta.library.meta.DataType;

public class LibraryDb {
	
	private static final String TABLE_LANGUAGES = "languages";
	private static final String COLUMNS_LANGUAGES = "lang_name";
	private static final String ID_LANGUAGES = "lang_id";
	
	
	private Connection conn;

	public LibraryDb(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public Language addLanguage(String langName){
		Statement stat;
		Language newLang = null;
		
		String sql = "INSERT INTO "
				+ TABLE_LANGUAGES + " ("
				+ COLUMNS_LANGUAGES + ") "
				+ "VALUES ('"
				+ langName + "')";
		
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			
			String getLast = "SELECT MAX("
					+ ID_LANGUAGES + ") "
					+ "FROM "
					+ TABLE_LANGUAGES;
			ResultSet res = stat.executeQuery(getLast);
			res.first();
			newLang = new Language (res.getString("MAX(" + ID_LANGUAGES + ")"), langName);
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return newLang;
	}
	
	 public ResultSet getAll(DataType dataType){
		 Statement stat;
		 ResultSet res = null;
		 
		 String sql = "SELECT * FROM "
				 + dataType.getTableName();
		 
		 try{
			 stat = conn.createStatement();
			 res = stat.executeQuery(sql);
		 } catch (SQLException e){
			 e.printStackTrace();
		 }
		 
		 return res;
	 }
	 
	 public void delete (DataType dataType, String id){
		 Statement stat;
		 String sql = "DELETE FROM "
				 + dataType.getTableName()
				 + " WHERE "
				 + dataType.getIdColumn()
				 + " = '" + id + "'";
		 
		 try{
			 stat = conn.createStatement();
			 stat.executeUpdate(sql);
		 } catch (SQLException e){
			 e.printStackTrace();
		 }
	 }

}
