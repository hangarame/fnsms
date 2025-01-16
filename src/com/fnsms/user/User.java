package com.fnsms.user;

/**
 * 모든 사용자의 공통된 정보가 담긴 클래스입니다.
 * @author 1조
 */
public class User {
	
	protected String name;
	protected String tel;
	protected String birthDate;
	
	public User(String name, String tel, String birthDate) {
		this.name = name;
		this.tel = tel;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [name=");
		builder.append(name);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
