package com.krimanta.library.dto;

public class Writer extends MyDto {
	
	private String writName, writId, writDob, writDod, WritAlive;

	public Writer(String writName, String writId, String writDob,
			String writDod, String writAlive) {
		super();
		this.writName = writName;
		this.writId = writId;
		this.writDob = writDob;
		this.writDod = writDod;
		WritAlive = writAlive;
	}

	public String getWritName() {
		return writName;
	}

	public void setWritName(String writName) {
		this.writName = writName;
	}

	public String getWritId() {
		return writId;
	}

	public void setWritId(String writId) {
		this.writId = writId;
	}

	public String getWritDob() {
		return writDob;
	}

	public void setWritDob(String writDob) {
		this.writDob = writDob;
	}

	public String getWritDod() {
		return writDod;
	}

	public void setWritDod(String writDod) {
		this.writDod = writDod;
	}

	public String getWritAlive() {
		return WritAlive;
	}

	public void setWritAlive(String writAlive) {
		WritAlive = writAlive;
	}
	
	

}
