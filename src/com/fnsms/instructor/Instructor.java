package com.fnsms.instructor;

import java.util.ArrayList;

import com.fnsms.attendance.Attendance;
import com.fnsms.emp.Emp;



public class Instructor extends Emp {
	
	private int iningCost;

	public Instructor(String name, String tel, String birthDate, String empNo, String role, int iningCost) {
		super(name, tel, birthDate, empNo, role);
		this.iningCost = iningCost;
	}

	public int getIningCost() {
		return iningCost;
	}

	public void setIningCost(int iningCost) {
		this.iningCost = iningCost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Instructor [iningCost=");
		builder.append(iningCost);
		builder.append(", empNo=");
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
