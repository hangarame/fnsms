package com.fnsms.emp;

import com.fnsms.user.User;
/**
 * 강사 및 관리자의 기본 데이터 클래스 입니다.
 * @author 1조
 */
public class Emp extends User{
	protected String empNo;
	protected String role;

	public Emp(String name, String tel, String birthDate, String empNo, String role) {
		super(name, tel, birthDate);
		this.empNo = empNo;
		this.role = role;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [empNo=");
		builder.append(empNo);
		builder.append(", role=");
		builder.append(role);
		builder.append(", name=");
		builder.append(name);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append("]");
		return builder.toString();
	}

	
	 
}
