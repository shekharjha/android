package com.shk.autocomplete;

public class Colors {
	private int id;
	private String colorName;
	
	public Colors(int id, String colorName) {
		super();
		this.id = id;
		this.colorName = colorName;
	}
	
	public Colors() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
}
