package com.chacha.guide.signup.beans;

public enum Gender {
	MALE("M"),
	FEMALE("F");
	
	/* -------------------- */
	private final String letter;
	
	private Gender(String letter) {
		this.letter = letter;
	}
	
	public String letter() {
		return letter;
	}
}