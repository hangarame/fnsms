package com.fnsms.instructor;

import java.util.ArrayList;

import com.fnsms.attendance.Attendance;
import com.fnsms.emp.Emp;



public class Instructor extends Emp {
	
	private int iningCost;
	private ArrayList<Attendance> Attendance;
	
	public Instructor(String name, String tel, String birthDate, String empNo, String role, int iningCost,
			ArrayList<com.fnsms.attendance.Attendance> attendance) {
		super(name, tel, birthDate, empNo, role);
		this.iningCost = iningCost;
		Attendance = attendance;
	}

	public int getIningCost() {
		return iningCost;
	}

	public void setIningCost(int iningCost) {
		this.iningCost = iningCost;
	}

	public ArrayList<Attendance> getAttendance() {
		return Attendance;
	}

	public void setAttendance(ArrayList<Attendance> attendance) {
		Attendance = attendance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Instructor [iningCost=");
		builder.append(iningCost);
		builder.append(", Attendance=");
		builder.append(Attendance);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
