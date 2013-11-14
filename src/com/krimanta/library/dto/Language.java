package com.krimanta.library.dto;

public class Language extends MyDto {
	
	public Language() {}

	public Language(String langId, String langName) {
		super();
		this.langId = langId;
		this.langName = langName;
	}
	
	

	String langId, langName;

	public String getLangId() {
		return langId;
	}

	public void setLangId(String langId) {
		this.langId = langId;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

}
