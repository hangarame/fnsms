package com.fnsms.emp;

import com.fnsms.user.User;

public class Emp extends User{
	private String empNo;
	private String role;
	 
	public Emp(String empNo, String role) {
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
		builder.append("]");
		return builder.toString();
	}
	 
}
