package com.fnsms.administrator;

import com.fnsms.emp.Emp;

public class Administrator extends Emp {

	public Administrator(String name, String tel, String birthDate, String empNo, String role) {
		super(name, tel, birthDate, empNo, role);

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Administrator [empNo=");
		builder.append(empNo);
		builder.append(", role=");
		builder.append(role);
		builder.append(", name=");
		builder.append(name);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", getEmpNo()=");
		builder.append(getEmpNo());
		builder.append(", getRole()=");
		builder.append(getRole());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getTel()=");
		builder.append(getTel());
		builder.append(", getBirthDate()=");
		builder.append(getBirthDate());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}
	
	
}
