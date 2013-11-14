package com.krimanta.library;

import com.krimanta.library.db.*;

public class Factory {
	
	public static LibraryDb getDb(){
		return new LibraryDb(DbConnection.getConnection());
	}

}
